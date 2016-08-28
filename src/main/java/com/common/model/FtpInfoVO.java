package com.common.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * 
 * @author wangzhengwu @ 对FTP服务器信息的一些描述，此信息由DRAGON系统传过来。
 * 
 */

public class FtpInfoVO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6712706105567254487L;

	private String strictHostKeyChecking = "no";
	// private int sessionTimeOut =0 ;//暂时不设置超时
	
	// Add by ken
	private String lspEntry;
	
	private String lspCode;
	private String ip;// IP地址或者//---
	private int port = 0;// ---
	private String user;// ---
	private String pwd;// ---
	
	private String lspName;
	private String lspAbbr;// ---
	private String lspDesc;
	private String fileNameEncoding = "UTF-8";// ---
	
	private String uuid = null;
	
	private String rootDir;// 用户FTP所在根目录
	private String preOrderDir;
	private String finalOrderDir;
	private String tntOutDir;
	private String tntInDir;
	private String orderNumRelationInDir;
	
	//2010/12/21 ZhangXiaolong Add Start
	private final static String rootDirName="rootDir";// 用户FTP所在根目录名
	private final static String preOrderDirName="preOrderDir";
	private final static String finalOrderDirName="finalOrderDir";
	private final static String tntOutDirName="tntOutDir";
	private final static String tntInDirName="tntInDir";
	private final static String orderNumRelationInDirName="orderNumRelationInDir";
	//2010/12/21 ZhangXiaolong Add End
	

	public String getUuid() 
	{
		if(uuid == null)
		{
			return UUID.randomUUID().toString();
		}
		else
		{
			return this.uuid;
		}
	}

	public void setUuid(String uuid) 
	{
		this.uuid = uuid;
	}

	public String getLspName() {
		return lspName;
	}

	public void setLspName(String lspName) {
		this.lspName = lspName;
	}

	public String getLspAbbr() {
		return lspAbbr;
	}

	public void setLspAbbr(String lspAbbr) {
		this.lspAbbr = lspAbbr;
	}

	public String getLspDesc() {
		return lspDesc;
	}

	public void setLspDesc(String lspDesc) {
		this.lspDesc = lspDesc;
	}

	public String getFileNameEncoding() {
		return fileNameEncoding;
	}

	public void setFileNameEncoding(String fileNameEncoding) {
		this.fileNameEncoding = fileNameEncoding;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getStrictHostKeyChecking() {
		return strictHostKeyChecking;
	}

	public void setStrictHostKeyChecking(String strictHostKeyChecking) {
		this.strictHostKeyChecking = strictHostKeyChecking;
	}

	public String getFinalOrderDir() {
		return finalOrderDir;
	}

	public void setFinalOrderDir(String finalOrderDir) {
		this.finalOrderDir = finalOrderDir;
	}

	public String getOrderNumRelationInDir() {
		return orderNumRelationInDir;
	}

	public void setOrderNumRelationInDir(String orderNumRelationInDir) {
		this.orderNumRelationInDir = orderNumRelationInDir;
	}

	public String getPreOrderDir() {
		return preOrderDir;
	}

	public void setPreOrderDir(String preOrderDir) {
		this.preOrderDir = preOrderDir;
	}

	public String getTntInDir() {
		return tntInDir;
	}

	public void setTntInDir(String tntInDir) {
		this.tntInDir = tntInDir;
	}

	public String getTntOutDir() {
		return tntOutDir;
	}

	public void setTntOutDir(String tntOutDir) {
		this.tntOutDir = tntOutDir;
	}

	public String getLspCode() {
		return lspCode;
	}

	public void setLspCode(String lspCode) {
		this.lspCode = lspCode;
	}
	//2010/12/21 ZhangXiaolong Add Start

	public static String getRootdirname() {
		return rootDirName;
	}

	public static String getPreorderdirname() {
		return preOrderDirName;
	}

	public static String getFinalorderdirname() {
		return finalOrderDirName;
	}

	public static String getTntoutdirname() {
		return tntOutDirName;
	}

	public static String getTntindirname() {
		return tntInDirName;
	}

	public static String getOrdernumrelationindirname() {
		return orderNumRelationInDirName;
	}
	//2010/12/21 ZhangXiaolong Add End

	public String getLspEntry() {
		return lspEntry;
	}

	public void setLspEntry(String lspEntry) {
		this.lspEntry = lspEntry;
	}


}
