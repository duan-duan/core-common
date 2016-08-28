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
 *    分页接口<br>
 * @author huanggaoren
 *
 * @date 2012 2012-9-22 上午07:29:25
 *
 * @version 1.0
 */
package com.common.page;

public interface Paginable {
	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public long getTotalCount();

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public long getTotalPage();

	/**
	 * 每页记录数
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * 当前页号
	 * 
	 * @return
	 */
	public long getPageNo();

	/**
	 * 是否第一页
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * 是否最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * 返回下页的页号
	 */
	public long getNextPage();

	/**
	 * 返回上页的页号
	 */
	public long getPrePage();
}
