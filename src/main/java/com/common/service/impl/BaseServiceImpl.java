/**
 * 
 */
package com.common.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.common.dao.BaseMapper;
import com.common.entity.BaseEntity;
import com.common.page.Pagination;
import com.common.page.SimplePage;
import com.common.service.BaseService;
import com.google.common.collect.Maps;

/**
 * @author huanggaoren
 * 
 */
public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable>
		implements BaseService<T, ID> {

	public abstract BaseMapper<T, ID> getMapper();

	/**
	 * 增加
	 * 
	 * @param t
	 */
	public int createEntity(T t) {
		return this.getMapper().createEntity(t);
	}

	/**
	 * 更新
	 * 
	 * @param t
	 */
	public int updateEntity(T t) {
		return this.getMapper().updateEntity(t);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public int deleteById(ID id) {
		return this.getMapper().deleteById(id);
	}

	/**
	 * 根据ID数组删除对象
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByIds(ID[] ids) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("ids", ids);
		return this.getMapper().deleteByIds(params);
	}

	/**
	 * 根据对象删除
	 * 
	 * @param t
	 * @return
	 */
	public int deleteByObject(T t) {
		return this.getMapper().deleteByObject(t);
	}

	/**
	 * 查询统计
	 * 
	 * @return
	 */
	public long pageQueryEntityCount() {
		return pageQueryEntityCount(null);
	}

	/**
	 * 查询统计
	 * 
	 * @return
	 */
	public long pageQueryEntityCount(T t) {
		return this.getMapper().pageQueryEntityCount(t);
	}

	/**
	 * 分页查询
	 * 
	 * *
	 * <p>
	 * 不带参数查询分页
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> pageQueryEntity(Long page, Integer rows) {
		return pageQueryEntity(page, rows, null);
	}

	/**
	 * 分页查询
	 * <p>
	 * 带参数，默认排序
	 * </P>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> pageQueryEntity(Long page, Integer rows, T t) {
		page = SimplePage.cpn(page);
		rows = (rows == null || rows == 0) ? 10 : rows;
		Pagination<T> pagination = getPageList(page, rows, t, null, null);
		Map<String, Object> map = Maps.newHashMap();
		map.put("total", pagination.getTotalCount());// total键
		// 存放总记录数，必须的
		map.put("rows", pagination.getCollection());// rows键 存放每页记录 list
		return map;
	}

	/**
	 * 分页查询
	 * 
	 * *
	 * <p>
	 * 带参数，自定义排序
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> pageQueryEntity(Long page, Integer rows, T t,
			String sort, String order) {
		page = SimplePage.cpn(page);
		rows = (rows == null || rows == 0) ? 10 : rows;
		Pagination<T> pagination = getPageList(page, rows, t, sort, order);
		Map<String, Object> map = Maps.newHashMap();
		map.put("total", pagination.getTotalCount());// total键
		// 存放总记录数，必须的
		map.put("rows", pagination.getCollection());// rows键 存放每页记录 list
		return map;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	private Pagination<T> getPageList(long pageNo, int pageSize, T t,
			String sort, String order) {
		long totalCount = this.getMapper().pageQueryEntityCount(t);
		Pagination<T> p = new Pagination<T>(pageNo, pageSize, totalCount);
		if (totalCount < 1) {
			p.setCollection(new ArrayList<T>());
			return p;
		}
		t.setPageSize(pageSize);
		t.setPosStart(pageNo);
		t.setTotalCount(totalCount);
		if (StringUtils.isNotEmpty(sort)) {
			t.setOrderCols(sort);
		}
		if (StringUtils.isNotEmpty(order)) {
			t.setDirection(order);
		}
		List<T> list = this.getMapper().pageQueryEntity(t);
		p.setCollection(list);
		return p;
	}

	/**
	 * 根据id找到对象
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(ID id) {
		return this.getMapper().queryById(id);
	}

	/**
	 * 根据参数对象查询对象
	 * 
	 * @param t
	 * @return
	 */
	public T queryByEntity(T t) {
		if (t == null) {
			return null;
		}
		return this.getMapper().queryByEntity(t);
	}

	/**
	 * 根据Map查询对象
	 * 
	 * @param t
	 * @return
	 */
	@SuppressWarnings("null")
	public T queryByMap(Map<String, String> map) {
		if (map == null && map.size() < 0) {
			return null;
		}
		return this.getMapper().queryByMap(map);
	}

	/**
	 * 查询所有的出列表
	 * 
	 * @return
	 */
	public List<T> queryList() {
		return queryListByEntity(null);
	}

	/**
	 * 查询所有的出列表
	 * 
	 * @return
	 */
	public List<T> queryListByEntity(T t) {
		return this.getMapper().queryListByEntity(t);
	}

	/**
	 * 根据Map参数来查询
	 * 
	 * @param map
	 * @return
	 */
	public List<T> queryListByMap(Map<String, String> map) {
		return this.getMapper().queryListByMap(map);
	}

}
