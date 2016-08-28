package com.common.util;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class BarCodeUtil {

	/**
	 * #P#hasSerail(Y/N)#Date(YYYYMMDDHHmm)#receivingID#PartNum#venderCode#Qty#PO-Batch-ID#SerialNo#Vender_Loc#part_type#product_category#process_code
	 */
	public static boolean isValidPart(String partNumBarcode) {
		
		/*按"#"分割货品条码*/
		String str[] = partNumBarcode.split("\\#");
		
		if((str.length != 13 && str.length != 14) || !str[1].equals("P")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 解析商品条码获取商品编码
	 * @param partNumBarcode
	 * @return
	 */
	public static String getPartNum(String partNumBarcode) {
		
		/*按"#"分割货品条码*/
		String str[] = partNumBarcode.split("\\#");
		
		return str[5];
	}
	
	/**
	 * 解析商品条码获取批次号
	 * @param partNumBarcode
	 * @return
	 */
	public static String getBatchId(String partNumBarcode) {
		
		/*按"#"分割货品条码*/
		String str[] = partNumBarcode.split("\\#");
		
		return str[8];
	}
	
	/**
	 * 解析商品条码获取序列号
	 * @param partNumBarcode
	 * @return
	 */
	public static String getSerialNum(String partNumBarcode) {

		/*按"#"分割货品条码*/
		String str[] = partNumBarcode.split("\\#");
		
		if(!str[2].equals("Y")) {
			return "";
		}
		
		return str[9];
	}
	
	
	/**
	 * 解析商品条码获取vendor_loc
	 * @param partNumBarcode
	 * @return
	 */
	public static String getVendorLoc(String partNumBarcode) {
		
		/*按"#"分割货品条码*/
		String str[] = partNumBarcode.split("\\#");
		
		return str[10];
	}
	
	/**
	 * 解析商品条码获取vendor_code
	 * @param partNumBarcode
	 * @return
	 */
	public static String getVendorCode(String partNumBarcode) {
		
		/*按"#"分割货品条码*/
		String str[] = partNumBarcode.split("\\#");
		
		return str[6];
	}
	
	/**
	 * 4000000001-4000999999=包装材料 纸箱
	 * 4100000000-4199999999=包装材料 塑料袋
	 * 4200000000-4299999999=包装材料 其他辅料
	 * 4000000000           =无包装代码
	 */
	public static boolean isValidMaterial(String materialBarCode) {
		
		/*如果字符串不全是数字，不是包装材料*/
		if(!isNumberic(materialBarCode) || materialBarCode.length() != 10) {
			return false;
		}
		
		/*截取前2为数字进行有效性验证*/
		int i = Integer.valueOf(materialBarCode.substring(0, 2));
		if(i < 40 || i > 42) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * #G#当前箱#总箱数#orderNo/ITRNo#type(O-order, I-ITR)#scanFlag#qty#part#qty2#part#...@长宽高重量
	 * @param packageBarCode
	 * @return
	 */
	public static boolean isValidPackage(String packageBarCode) {
		
		/*按"@"分割货品条码,舍弃后半截长宽高重量*/
		String box[] = packageBarCode.split("\\@");
		
		/*按"#"分割前半截字符串*/
		String str[] = box[0].split("\\#");
		
		if(str.length < 6 || !str[1].equals("G")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 解析箱标签条码获取订单号
	 * @param boxLabelBarCode
	 * @return
	 */
	public static String getOrderNum(String boxLabelBarCode) {
		
		/*按"@"分割货品条码,舍弃后半截长宽高重量*/
		String box[] = boxLabelBarCode.split("@");
		
		/*按"#"分割前半截字符串*/
		String str[] = box[0].split("\\#");
		
		return str[4];
	}
	
	/**
	 * 解析箱标签条码获取该订单总箱数
	 * @param boxLabelBarCode
	 * @return
	 */
	public static int getBoxQty(String boxLabelBarCode) {
		
		/*按"@"分割货品条码,舍弃后半截长宽高重量*/
		String box[] = boxLabelBarCode.split("@");
		
		/*按"#"分割前半截字符串*/
		String str[] = box[0].split("\\#");
		
		return Integer.valueOf(str[3]);
	}
	
	
	/**
	 * 解析箱标签条码获取当前第几箱
	 * @param boxLabelBarCode
	 * @return
	 */
	public static String getCurrentBoxId(String boxLabelBarCode) {
		
		/*按"@"分割货品条码,舍弃后半截长宽高重量*/
		String box[] = boxLabelBarCode.split("@");
		
		/*按"#"分割前半截字符串*/
		String str[] = box[0].split("\\#");
		
		return str[2];
	}
	
	public static String getBoxWeight(String boxLabelBarCode) {
		
		String box[] = boxLabelBarCode.split("@");
		
		/*按"#"分割后半截字符串*/
		String str[] = box[1].split("\\#");
		
		return str[3];
	}
	
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumberic(String str) {
		
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * #R#BoxID
	 */
	public static boolean isValidPackingLabel(String packingLabel) {
		
		/*按"#"分割入库包装箱标签*/
		String str[] = packingLabel.split("\\#");
		
		if(str.length != 3 || !str[1].equals("R")) {
			return false;
		}
		
		return true;
	}
	/**
	 * 解析入库包装标签获取BOX_ID
	 * @param partNumBarcode
	 * @return
	 */
	public static String getBoxId(String packingLabel) {
		
		/*按"#"分割入库包装标签*/
		String str[] = packingLabel.split("\\#");
		
		return str[2];
	}
	
	/**
	 * 解析商品条码获取process_code
	 * @param partLabel
	 * @return
	 */
	public static String getProcessCode(String partLabel) {
		
		/*按"#"分割货品条码*/
		String str[] = partLabel.split("\\#");
		if(str.length>13){
			return str[13];
		}
		return "";
	}
	
	/**
	 * 从一维码中获取订单号
	 * @return
	 */
	public static String getOrderNumFromLabel(String labelStr){
		String orderNum = null;
		
		if((null!=labelStr)&&(labelStr.trim().length()>=10)){
			/**
			 * 取前10位作为订单号
			 */
			orderNum = labelStr.trim().substring(0, 10);
		}
		return orderNum;
	}
	
	/**
	 * 判断输入的String是否为一维码
	 * 校验依据：1.一共12位 2.纯数字串
	 * @param label
	 * @return
	 */
	public static boolean isOneDimensionalCode(String label){
			
		if((label.length()==12)&&(isNumberic(label))){
			return true;
		}
		return false;
	}
	
	/**
	 * 截取一维码后两位，取得箱序号
	 * @param boxLabel
	 * @return
	 */
	public static String getOneDimensionalBoxId(String boxLabel){
		return String.valueOf(Integer.parseInt(StringUtils.substring(boxLabel, 10)));
	}
	
	/**
	 * 校验一维码格式(12位数字)
	 * @param oneDemension
	 * @return
	 */
	public static boolean isValidOneDemension(String oneDemension){
		
		if(oneDemension.length()==12 && isNumberic(oneDemension)){
			return true;
		}
		return false;
	}
	
}

