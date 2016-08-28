/**
 * @projectName:tms
 * 
 * @packageName:com.gome.core.page
 *
 * @Title:SimplePage.java
 * 
 * @ClassName:SimplePage 
 *
 * @Description:TODO
 *    列表分页。包含list属性。<br>
 * @author huanggaoren
 *
 * @date 2012 2012-9-22 上午07:29:25
 *
 * @version 1.0
 */
package com.common.page;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.common.entity.BaseSerializable;

public class Pagination<T> extends SimplePage implements BaseSerializable,
		Paginable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1503272500208949461L;

	public Pagination() {
	}

	public Pagination(HttpServletRequest request) {
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		if (StringUtils.isNotEmpty(pageNo)) {
			this.setPageNo(Long.valueOf(pageNo));
		}
		if (StringUtils.isNotEmpty(pageSize)) {
			this.setPageSize(Integer.valueOf(pageSize));
		}
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pagination(long pageNo, int pageSize, long totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 */
	public Pagination(long pageNo, int pageSize) {
		super(pageNo, pageSize);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(long pageNo, int pageSize, long totalCount,
			Collection<T> collection) {
		super(pageNo, pageSize, totalCount);
		this.collection = collection;
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(long pageNo, int pageSize, long totalCount,
			List<LinkedHashMap<String, Object>> linkedHashMap) {
		super(pageNo, pageSize, totalCount);
		this.linkedHashMap = linkedHashMap;
	}

	/**
	 * 当前数据索引位置
	 * 
	 * @return
	 */
	public long getCurrentDateIndex() {
		return (super.getPageNo() - 1) * super.getPageSize();
	}

	/**
	 * 当前页的数据
	 */
	private Collection<T> collection;

	private List<LinkedHashMap<String, Object>> linkedHashMap;

	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}

	public List<LinkedHashMap<String, Object>> getLinkedHashMap() {
		return linkedHashMap;
	}

	public void setLinkedHashMap(List<LinkedHashMap<String, Object>> list) {
		this.linkedHashMap = list;
	}

}
