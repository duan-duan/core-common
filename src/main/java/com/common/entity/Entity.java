/**
 * 
 */
package com.common.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huanggaoren
 * 
 */
public abstract class Entity implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1852540751755466319L;

	/**
	 * 每页显示的条数
	 */
	private int pageSize = 10;

	/**
	 * 总条数
	 */
	private long totalCount = 0;

	/**
	 * 每页默认条数
	 */
	private int DEF_COUNT = 10;

	/**
	 * 游标位置
	 */
	private long posStart = 0;

	/**
	 * 排序字段
	 */
	private String orderCols;

	/**
	 * 默认排序
	 */
	private String direction = "desc";

	/**
	 * 升序
	 */
	private static final String DIRECTION_ASC = "asc";

	/**
	 * 降序
	 */
	private static final String DIRECTION_DESC = "desc";

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		if (StringUtils.isEmpty(direction)
				|| direction.equalsIgnoreCase(DIRECTION_ASC)) {
			return DIRECTION_ASC;
		}
		return DIRECTION_DESC;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the orderCols
	 */
	public String getOrderCols() {
		return orderCols;
	}

	/**
	 * @param orderCols
	 *            the orderCols to set
	 */
	public void setOrderCols(String orderCols) {
		this.orderCols = orderCols;
	}

	/**
	 * @return the dEF_COUNT
	 */
	public int getDEF_COUNT() {
		if (getPageSize() > 0) {
			return pageSize;
		} else {
			return DEF_COUNT;
		}
	}

	/**
	 * @param def_count
	 *            the dEF_COUNT to set
	 */
	public void setDEF_COUNT(int def_count) {
		DEF_COUNT = def_count;
	}

	/**
	 * @return the posStart
	 */
	public long getPosStart() {
		long totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		if (posStart <= 0) {
			return 0;
		} else if (posStart > totalPage) {
			return (totalPage - 1) * pageSize;
		} else {
			return (posStart - 1) * pageSize;
		}
	}

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @param posStart
	 *            the posStart to set
	 */
	public void setPosStart(long posStart) {
		this.posStart = posStart;
	}

	public Entity() {

	}

}
