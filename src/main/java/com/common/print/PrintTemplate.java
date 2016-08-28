/**
 * 
 */
package com.common.print;

import com.common.entity.BaseSerializable;

/**
 * @author huanggaoren
 *
 *         打印模板类
 */
public class PrintTemplate implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 510165870591240717L;

	private String labelId;

	private PrintType printType;

	private String fullPath;

	private String printerName;

	private String groupId;

	private String mediaSizeName;

	private int copies;

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public PrintType getPrintType() {
		return printType;
	}

	public void setPrintType(PrintType printType) {
		this.printType = printType;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getPrinterName() {
		return printerName;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMediaSizeName() {
		return mediaSizeName;
	}

	public void setMediaSizeName(String mediaSizeName) {
		this.mediaSizeName = mediaSizeName;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
}
