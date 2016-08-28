package com.common.entity;

import java.util.Date;

/**
 * 
 * @author huanggaoren
 * 
 */
public abstract class BaseEntity extends Entity implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9213313747215751818L;

	/**
	 * 创建信息者----一般为系统登陆者
	 */
	protected String insertBy;

	/**
	 * 创建信息时间----例如：当前系统时间
	 */
	protected Date insertDate = new Date();

	/**
	 * 更新信息者----一般为系统登陆者
	 */
	protected String modifiedBy;

	/**
	 * 更新信息时间
	 */
	protected Date modifiedDate = new Date();

	/**
	 * 版本号
	 * <p>
	 * 不存储在数据库中
	 * </p>
	 */
	private String version = "1.0.0";

	public String getInsertBy() {
		return insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
