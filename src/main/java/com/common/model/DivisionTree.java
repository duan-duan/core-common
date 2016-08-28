package com.common.model;

import java.util.List;

import com.common.entity.BaseSerializable;

/**
 * 
 * @author guoqiushi
 *
 */
public class DivisionTree implements BaseSerializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6610338760905578894L;
	/**
	 * iD
	 */
	private String id;
	/**
	 * 父类ID
	 */
	private String pid;

	/**
	 * 名称
	 */
	private String text;

	/**
	 * 状态
	 */
	private String state = "closed";

	/**
	 * 是否选中
	 */
	private boolean checked = false;

	/**
	 * 子菜单
	 */
	private List<DivisionTree> children;
	
	/**
	 * 区域级别
	 */
	private int divLevel; 

	
	public DivisionTree() {
	}


	public DivisionTree(String id, String pid, String text, int divLevel) {
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.divLevel = divLevel;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<DivisionTree> getChildren() {
		return children;
	}

	public void setChildren(List<DivisionTree> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


	public int getDivLevel() {
		return divLevel;
	}


	public void setDivLevel(int divLevel) {
		this.divLevel = divLevel;
	}


}
