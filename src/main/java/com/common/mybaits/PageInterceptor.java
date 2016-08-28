/**
 * 
 */
package com.common.mybaits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.common.page.Pagination;
import com.common.util.PropertiesUtils;

/**
 * @author huanggaoren
 *
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
@SuppressWarnings({ "unchecked"})
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation
				.getTarget();
		// 通过反射获取到当前RoutingStatementHandler对象的delegate属性
		StatementHandler delegate = (StatementHandler) ReflectUtil
				.getValueByFieldName(handler, "delegate");
		MappedStatement mappedStatement = (MappedStatement) ReflectUtil
				.getValueByFieldName(delegate, "mappedStatement");
		String dialect = PropertiesUtils.getPropValue(mappedStatement.getId());
		if (StringUtils.isEmpty(dialect)) {
			return invocation.proceed();
		}
		BoundSql boundSql = delegate.getBoundSql();
		Object parameterObject = boundSql.getParameterObject();// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
		if (parameterObject == null) {
			throw new NullPointerException("parameterObject尚未实例化！");
		} else {
			Pagination<?> page = null;
			if (parameterObject instanceof Map) { // 参数就是Page实体
				Connection connection = (Connection) invocation.getArgs()[0];
				for (Map.Entry<String, Object> e : ((Map<String, Object>) parameterObject)
						.entrySet()) {
					if (e.getValue() instanceof Pagination<?>) {
						page = (Pagination<?>) e.getValue();
						break;
					}
				}
				if (page == null) {
					return invocation.proceed();
				}
				this.setTotalRecord(page, boundSql, mappedStatement,
						connection, parameterObject);
				// 利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
			}
			String sql = boundSql.getSql();
			String pageSql = this.getPageSql(page, sql, dialect);
			ReflectUtil.setValueByFieldName(boundSql, "sql", pageSql);
		}
		return invocation.proceed();
	}

	/**
	 * 给当前的参数对象page设置总记录数
	 *
	 * @param page
	 *            Mapper映射语句对应的参数对象
	 * @param mappedStatement
	 *            Mapper映射语句
	 * @param connection
	 *            当前的数据库连接
	 */
	private void setTotalRecord(Pagination<?> page, BoundSql boundSql,
			MappedStatement mappedStatement, Connection connection,
			Object parameterObject) {
		// 获取到我们自己写在Mapper映射语句中对应的Sql语句
		String sql = boundSql.getSql();
		// 通过查询Sql语句获取到对应的计算总记录数的sql语句
		String countSql = this.getCountSql(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			// 之后就是执行获取总记录数的Sql语句和获取结果了。
			rs = pstmt.executeQuery();
			int totalRecord = 0;
			if (rs.next()) {
				totalRecord = rs.getInt(1);
			}
			// 给当前的参数page对象设置总记录数
			page.setTotalCount(totalRecord);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * 根据原Sql语句获取对应的查询总记录数的Sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public String getCountSql(String sql) {
		if (StringUtils.isNotEmpty(sql)) {
			String sqlNew = sql.toUpperCase();
			int index = sqlNew.indexOf("FROM");
			return "select count(*) " + sql.substring(index);
		}
		return sql;
	}

	/**
	 * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle 其它的数据库都 没有进行分页
	 *
	 * @param page
	 *            分页对象
	 * @param sql
	 *            原sql语句
	 * @return
	 */
	public String getPageSql(Pagination<?> page, String sql, String dialect) {
		if (page != null && StringUtils.isNotEmpty(dialect)) {
			StringBuffer sqlBuffer = new StringBuffer(sql);
			if ("mysql".equalsIgnoreCase(dialect)) {
				return getMysqlPageSql(page, sqlBuffer);
			} else if ("oracle".equalsIgnoreCase(dialect)) {
				return getOraclePageSql(page, sqlBuffer);
			}
			return sqlBuffer.toString();
		} else {
			return sql;
		}
	}

	/**
	 * 获取Mysql数据库的分页查询语句
	 * 
	 * @param page
	 *            分页对象
	 * @param sqlBuffer
	 *            包含原sql语句的StringBuffer对象
	 * @return Mysql数据库分页语句
	 */
	public String getMysqlPageSql(Pagination<?> page, StringBuffer sqlBuffer) {
		// 计算第一条记录的位置，Mysql中记录的位置是从0开始的。
		if (page != null) {
			long offset = page.getCurrentDateIndex();
			sqlBuffer.append(" limit  ").append(offset).append(" , ")
					.append(page.getPageSize());
		}
		return sqlBuffer.toString();
	}

	/**
	 * 获取Oracle数据库的分页查询语句
	 * 
	 * @param page
	 *            分页对象
	 * @param sqlBuffer
	 *            包含原sql语句的StringBuffer对象
	 * @return Oracle数据库的分页查询语句
	 */
	public String getOraclePageSql(Pagination<?> page, StringBuffer sqlBuffer) {
		// 计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的
		if (page != null) {
			long offset = (page.getPageNo() - 1) * page.getPageSize() + 1;
			sqlBuffer.insert(0, "select u.*, rownum r from (")
					.append(") u where rownum < ")
					.append(offset + page.getPageSize());
			sqlBuffer.insert(0, "select * from (").append(") where r >= ")
					.append(offset);
			// 上面的Sql语句拼接之后大概是这个样子：
			// select * from (select u.*, rownum r from (select * from t_user) u
			// where rownum < 31) where r >= 16
		}
		return sqlBuffer.toString();
	}

	@Override
	public void setProperties(Properties properties) {
	}
}
