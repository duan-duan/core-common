package com.common.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import com.common.constants.Constants;
import com.common.model.FtpInfoVO;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.SftpProgressMonitor;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public class FTPUtils {
	private HashMap<String, Vector> sessionPools = new HashMap<String, Vector>();
	private Vector<Session> sessionPool = new Vector<Session>();

	private static final String CHL_MODE_SFTP = "sftp";
	private Session session = null;
	private ChannelSftp chlSftp = null;
	private String fileNameEncoding = "UTF-8";

	public FTPUtils() {

	}

	public FTPUtils(FtpInfoVO sftpInfo) {
		try {
			getSession(sftpInfo);
		} catch (JSchException e) {
			e.printStackTrace();
		}
		getChlSftp(sftpInfo);
	}

	/**
	 * 
	 * @param sftpInfo
	 * @return com.jcraft.jsch.Session
	 * @throws JSchException
	 */
	public Session getSession(FtpInfoVO sftpInfo) throws JSchException {
		if (null != session) {
		} else {
			JSch jsch = new JSch();
			if (0 >= sftpInfo.getPort()) {
				session = jsch.getSession(sftpInfo.getUser(), sftpInfo.getIp());
			} else {
				session = jsch.getSession(sftpInfo.getUser(), sftpInfo.getIp(), sftpInfo.getPort());
			}
		}
		Properties sshConfig = new Properties();
		sshConfig.setProperty("StrictHostKeyChecking", sftpInfo.getStrictHostKeyChecking());
		session.setConfig(sshConfig);
		session.setPassword(sftpInfo.getPwd());
		return session;
	}

	/**
	 * Get ChannelSftp
	 * 
	 * @param sftpInfo
	 * @return ChannelSftp
	 */
	public ChannelSftp getChlSftp(FtpInfoVO sftpInfo) {
		if (null != chlSftp) {
			System.out.println("not null");
		} else {
			try {
				session = getSession(sftpInfo);
			} catch (JSchException e) {
				e.printStackTrace();
			}
			try {
				if (!session.isConnected())
					session.connect();
			} catch (JSchException e) {
				e.printStackTrace();
			}
			try {
				chlSftp = (ChannelSftp) session.openChannel(CHL_MODE_SFTP);
				chlSftp.connect();
				chlSftp.setFilenameEncoding(sftpInfo.getFileNameEncoding());
			} catch (JSchException e) {
				e.printStackTrace();
				releaseSession();
				chlSftp = null;
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return chlSftp;
	}

	public final void releaseAll() {
		releaseChlSftp();
		releaseSession();
	}

	/**
	 * release session resource
	 */
	public final void releaseSession() {
		if (null == session || !session.isConnected()) {
			return;
		} else {
			try {
				session.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session = null;
			}
		}
	}

	/**
	 * release Sftp Channel resource
	 */
	public final void releaseChlSftp() {
		if (null == chlSftp || !chlSftp.isConnected()) {
			return;
		} else {
			try {
				chlSftp.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				chlSftp = null;
			}
		}
	}

	/**
	 * 
	 * @param src
	 *            源文件名
	 * @param dst
	 *            目的文件名
	 * @param monitor
	 * @param mode
	 *            = ChannelSftp.OVERWRITE、ChannelSftp.RESUME、ChannelSftp.APPEND
	 * @throws Exception
	 */
	public void put(String src, String dst, SftpProgressMonitor monitor, int mode) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		if (null == src) {
			throw new Exception(" upload null to ftp server is forbidden.");
		}
		try {
			chlSftp.put(src, dst, monitor, mode);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 以 OVERWRITE 方式写上传文件
	 * 
	 * @param src
	 *            源文件名
	 * @param dst
	 *            目的文件名
	 * @throws Exception
	 */
	public void put(String src, String dst) throws Exception {
		put(src, dst, null, ChannelSftp.OVERWRITE);
	}

	/**
	 * 
	 * @param src
	 *            源文件名
	 * @param dst
	 *            目的文件名
	 * @param mode
	 *            = ChannelSftp.OVERWRITE、ChannelSftp.RESUME、ChannelSftp.APPEND
	 * @throws Exception
	 */
	public void put(String src, String dst, int mode) throws Exception {
		put(src, dst, null, mode);
	}

	public void put(String src, String dst, SftpProgressMonitor monitor) throws Exception {
		put(src, dst, monitor, ChannelSftp.OVERWRITE);
	}

	/**
	 * 
	 * @param src
	 *            输入流
	 * @param dst
	 *            目的文件
	 * @param monitor
	 * @param mode
	 *            = ChannelSftp.OVERWRITE、ChannelSftp.RESUME、ChannelSftp.APPEND
	 * @throws Exception
	 */
	public void put(InputStream src, String dst, SftpProgressMonitor monitor, int mode) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		if (null == src) {
			throw new Exception(" upload null to ftp server is forbidden.");
		}
		try {
			chlSftp.put(src, dst, monitor, mode);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 以 OVERWRITE 方式上传文件
	 * 
	 * @param src
	 *            输入流
	 * @param dst
	 * @throws Exception
	 */
	public void put(InputStream src, String dst) throws Exception {
		put(src, dst, null, ChannelSftp.OVERWRITE);
	}

	public void put(InputStream src, String dst, int mode) throws Exception {
		put(src, dst, null, mode);
	}

	public void put(InputStream src, String dst, SftpProgressMonitor monitor) throws Exception {
		put(src, dst, monitor, ChannelSftp.OVERWRITE);
	}

	/**
	 * 
	 * @param dst
	 *            目的文件名
	 * @param monitor
	 * @param mode
	 * @param offset
	 * @return 输出流
	 * @throws SftpException
	 */
	public OutputStream put(String dst, final SftpProgressMonitor monitor, final int mode, long offset) throws SftpException {
		OutputStream os = null;
		try {
			os = chlSftp.put(dst, monitor, mode, offset);
		} catch (SftpException e) {
			e.printStackTrace();
			throw e;
		}
		return os;
	}

	/**
	 * 
	 * @param dst
	 *            目的文件名
	 * @param monitor
	 * @param mode
	 * @return 输出流
	 * @throws SftpException
	 */
	public OutputStream put(String dst, final SftpProgressMonitor monitor, final int mode) throws SftpException {
		return put(dst, monitor, mode, 0);
	}

	/**
	 * 
	 * @param dst
	 *            目的文件名
	 * @param mode
	 * @return 输出流
	 * @throws SftpException
	 */
	public OutputStream put(String dst, final int mode) throws SftpException {
		return put(dst, (SftpProgressMonitor) null, mode);
	}

	/**
	 * 
	 * @param dst
	 *            目的文件名
	 * @return 输出流
	 * @throws SftpException
	 */
	public OutputStream put(String dst) throws SftpException {
		return put(dst, (SftpProgressMonitor) null, ChannelSftp.OVERWRITE);
	}

	/**
	 * @deprecated
	 * @param src
	 * @param dst
	 * @param monitor
	 * @param mode
	 *            = ChannelSftp.OVERWRITE、ChannelSftp.RESUME、ChannelSftp.APPEND
	 * @throws Exception
	 */
	private void _put(InputStream src, String dst, SftpProgressMonitor monitor, int mode) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		if (null == src) {
			throw new Exception(" upload null to ftp server is forbidden.");
		}
		try {
			chlSftp._put(src, dst, monitor, mode);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param src
	 *            源文件名
	 * @param dst
	 *            目的文件名
	 * @param monitor
	 * @param mode
	 * @throws Exception
	 */
	public void get(String src, String dst, SftpProgressMonitor monitor, int mode) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		if (null == src) {
			throw new Exception(" upload null to ftp server is forbidden.");
		}
		try {
			chlSftp.get(src, dst, monitor, mode);
		} catch (Exception e) {
			throw e;
		}
	}

	public void get(String src, String dst) throws Exception {
		get(src, dst, null, ChannelSftp.OVERWRITE);
	}

	public void get(String src, String dst, SftpProgressMonitor monitor) throws Exception {
		get(src, dst, monitor, ChannelSftp.OVERWRITE);
	}

	/**
	 *
	 * @param src
	 * @param dst
	 * @param monitor
	 * @param mode
	 * @param skip
	 * @throws Exception
	 */
	private void get(String src, OutputStream dst, SftpProgressMonitor monitor, int mode, long skip) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		if (null == src) {
			throw new Exception(" upload null to ftp server is forbidden.");
		}
		try {
			chlSftp.get(src, dst, monitor, mode, skip);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * @param src
	 * @param dst
	 * @throws Exception
	 */
	public void get(String src, OutputStream dst) throws Exception {
		get(src, dst, null, ChannelSftp.OVERWRITE, 0);
	}

	/**
	 *
	 * @param src
	 * @param dst
	 * @param monitor
	 * @throws Exception
	 */
	public void get(String src, OutputStream dst, SftpProgressMonitor monitor) throws Exception {
		get(src, dst, monitor, ChannelSftp.OVERWRITE, 0);
	}

	/**
	 * @param src
	 *            文件名
	 * @param monitor
	 * @param skip
	 * @return 输入流
	 * @throws Exception
	 */
	public InputStream get(String src, final SftpProgressMonitor monitor, final long skip) throws Exception {
		InputStream inStream = null;
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		if (null == src) {
			throw new Exception(" upload null to ftp server is forbidden.");
		}
		try {
			inStream = chlSftp.get(src, monitor, skip);
		} catch (Exception e) {
			throw e;
		}
		return inStream;
	}

	/**
	 * 
	 * @param src
	 *            文件名
	 * @return 输入流
	 * @throws Exception
	 */
	public InputStream get(String src) throws Exception {
		return get(src, null, 0L);
	}

	/**
	 * 
	 * @param src
	 *            文件名
	 * @param monitor
	 * @return 输入流
	 * @throws Exception
	 */
	public InputStream get(String src, SftpProgressMonitor monitor) throws Exception {
		return get(src, monitor, 0L);
	}

	/**
	 * 改变本地路径[客户端]
	 *
	 * @param path
	 * @throws Exception
	 */
	public void lcd(String path) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		try {
			chlSftp.lcd(path);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 改变路径[服务器]
	 *
	 * @param path
	 * @throws Exception
	 */
	public void cd(String path) throws Exception {
		if (null == chlSftp || !chlSftp.isConnected()) {
			throw new Exception("sftp Channel invalid.");
		}
		try {
			chlSftp.cd(path);
		} catch (Exception e) {
			throw e;
		}
	}

	public Vector ls(String path) throws SftpException {
		return chlSftp.ls(path);
	}

	/**
	 * 过滤方式取path下面的文件，仅取文件后缀为suffix，不取文件夹
	 * 
	 * @param path
	 * @param suffix
	 * @return 文件名集合
	 * @throws SftpException
	 */
	public Vector ls(String path, String suffix) throws SftpException {
		Vector filses = chlSftp.ls(path);
		Vector myFilses = new Vector();
		Iterator it = filses.iterator();
		while (it.hasNext()) {
			LsEntry lsentry = (LsEntry) it.next();
			if (lsentry.getFilename().toLowerCase().endsWith(suffix.toLowerCase()) && lsentry.getLongname().startsWith("-")) {
				myFilses.add(lsentry);
			}
		}
		return myFilses;
	}

	/**
	 * 过滤方式取path下面的文件，仅取文件后缀为suffix，不取文件夹
	 * 
	 * @param path
	 * @return 文件夹下是否有文件
	 * @throws SftpException
	 */
	public boolean lsFolder(String path, String folderName) throws SftpException {
		Vector filses = chlSftp.ls(path);
		Iterator it = filses.iterator();
		while (it.hasNext()) {
			LsEntry lsentry = (LsEntry) it.next();
			if (lsentry.getLongname().startsWith("d") && folderName.equals(lsentry.getFilename())) {
				return false;
			}
		}
		return true;
	}

	public void rename(String oldpath, String newpath) throws SftpException {
		chlSftp.rename(oldpath, newpath);
	}

	/**
	 * 删除
	 * 
	 * @param path
	 * @throws SftpException
	 */
	public void rm(String path) throws SftpException {
		chlSftp.rm(path);
	}

	/**
	 * 更改文件所属用户
	 * 
	 * @param uid
	 * @param path
	 * @throws SftpException
	 */
	public void chown(int uid, String path) throws SftpException {
		chlSftp.chown(uid, path);
	}

	/**
	 * 更改文件权限
	 * 
	 * @param permissions
	 * @param path
	 * @throws SftpException
	 */
	public void chmod(int permissions, String path) throws SftpException {
		chlSftp.chmod(permissions, path);
	}

	/**
	 * 创建文件夹
	 * 
	 * @param path
	 * @throws SftpException
	 */
	public void mkdir(String path) throws SftpException {
		chlSftp.mkdir(path);
	}

	/**
	 * 删除文件夹
	 * 
	 * @param path
	 * @throws SftpException
	 */
	public void rmdir(String path) throws SftpException {
		chlSftp.rmdir(path);
	}

	/**
	 * 显示服务器当前所在路径
	 * 
	 * @return 当前路径
	 * @throws SftpException
	 */
	public String pwd() throws SftpException {
		return chlSftp.pwd();
	}

	/**
	 * 显示本地当前所在路径
	 * 
	 * @return 显示本地当前所在路径
	 */
	public String lpwd() {
		return chlSftp.lpwd();
	}

	public String version() {
		return chlSftp.version();
	}

	/**
	 * 得到用户的根目录
	 * 
	 * @return 得到用户的根目录
	 * @throws SftpException
	 */
	public String getHome() throws SftpException {
		return chlSftp.getHome();
	}


	public String getNewPathIfExist(String folderPath, String slash, String fileName) throws Exception 
	{
		Vector fileList = chlSftp.ls(folderPath);
		Iterator it = fileList.iterator(); 
		while (it.hasNext()) 
		{
			LsEntry lsentry = (LsEntry) it.next();
			if (fileName.equals(lsentry.getFilename()))
			{
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmsssssssss");
				String timeStr = dateformat.format(new Date());
				fileName = StringUtil.updateFileName(fileName, "_" + timeStr, StringUtil.getFileSuffix(fileName));
				break;
			}
		}
		return fileName;
	}

	/**
	 * 得到文件名称
	 *
	 * @return 文件名称
	 */
	public static String getFileName(String type) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String mDateTime = formatter.format(c.getTime());
		String datatime = mDateTime.substring(0, 15);// 20071029_093002
		String filename = Constants.OPERATIONTYPE.getNameByCode(type) + "_"
				+ datatime + "_" + GUIDGenerator.generate()
				+ Constants.File.suffix_csv;
		return filename;
	}
}
