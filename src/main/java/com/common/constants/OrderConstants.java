/**
 * 
 */
package com.common.constants;

/**
 * 存放订单状态常量的类
 * @author zhanghaiyang
 *
 */
public class OrderConstants {

	/**
	 * 订单类型枚举常量
	 */
	public static final String ORDER_TYPE_SO = "SO"; // 订单类型：送货
	public static final String ORDER_TYPE_RO = "RO"; // 订单类型：退货
	public static final String ORDER_TYPE_CRO = "CRO"; // 订单类型：大客户换货退货订单
	public static final String ORDER_TYPE_IO = "IO"; // 订单类型：安装服务订单
	public static final String ORDER_TYPE_RS = "RS"; // 订单类型：维修服务订单
	public static final String ORDER_TYPE_VO = "VO"; // 订单类型：多方面服务订单
	public static final String ORDER_TYPE_WO = "WO"; // 订单类型：延保修订单
	public static final String ORDER_TYPE_PR = "PR"; // 订单类型：换货退货订单
	public static final String ORDER_TYPE_PS = "PS"; // 订单类型：换货配送订单
	public static final String ORDER_TYPE_DPR = "DPR"; // 订单类型：自生换货退货订单
	public static final String ORDER_TYPE_DPS = "DPS"; // 订单类型：自生换货配送订单
	public static final String PAYMENT_TYPE_COD = "COD"; // 付款类型：货到付款
	public static final String PAYMENT_TYPE_PREPAID = "PAID"; //付款类型：款到发货
	public static final String SELF_PICKUP_FLAG_Y = "Y"; // 提货类型：自提
	public static final String SELF_PICKUP_FLAG_N = "N"; // 提货类型：非自提
	public static final String ORDER_TYPE_SO_V = "送货"; // 订单类型：送货
	public static final String ORDER_TYPE_RO_V = "退货"; // 订单类型：退货
	public static final String ORDER_TYPE_IO_V = "安装服务订单"; // 订单类型：安装服务订单
	public static final String ORDER_TYPE_RS_V = "维修服务订单"; // 订单类型：维修服务订单
	public static final String ORDER_TYPE_VO_V = "多方面服务订单"; // 订单类型：多方面服务订单
	public static final String ORDER_TYPE_WO_V = "延保修订单"; // 订单类型：延保修订单
	public static final String ORDER_TYPE_PR_V = "换货退货订单"; // 订单类型：换货退货订单
	public static final String ORDER_TYPE_PS_V = "换货配送订单"; // 订单类型：换货配送订单
	public static final String ORDER_TYPE_DPR_V = "自生换货退货订单"; // 订单类型：自生换货退货订单
	public static final String ORDER_TYPE_DPS_V = "自生换货配送订单"; // 订单类型：自生换货配送订单
	
	/**
	 * 根据传入的订单状态编码，获取相应的状态名称
	 * @param orderTypeCode
	 * @return
	 */
	public static String transferTypeCode2Name(String orderTypeCode){
		String orderTypeName = null;
		if (ORDER_TYPE_SO.equals(orderTypeCode)) {
			orderTypeName= ORDER_TYPE_SO_V;
		}else if (ORDER_TYPE_RO.equals(orderTypeCode))  {
			orderTypeName= ORDER_TYPE_RO_V;
		}else if (ORDER_TYPE_IO.equals(orderTypeCode)) {
			orderTypeName= ORDER_TYPE_IO_V;
		}else if (ORDER_TYPE_RS.equals(orderTypeCode))  {
			orderTypeName= ORDER_TYPE_RS_V;
		}else if (ORDER_TYPE_VO.equals(orderTypeCode)) {
			orderTypeName= ORDER_TYPE_VO_V;
		}else if (ORDER_TYPE_WO.equals(orderTypeCode))  {
			orderTypeName= ORDER_TYPE_WO_V;
		}else if (ORDER_TYPE_PR.equals(orderTypeCode)) {
			orderTypeName= ORDER_TYPE_PR_V;
		}else if (ORDER_TYPE_PS.equals(orderTypeCode))  {
			orderTypeName= ORDER_TYPE_PS_V;
		}else if (ORDER_TYPE_DPR.equals(orderTypeCode)) {
			orderTypeName= ORDER_TYPE_DPR_V;
		}else if (ORDER_TYPE_DPS.equals(orderTypeCode))  {
			orderTypeName= ORDER_TYPE_DPS_V;
		}else{
			orderTypeName = "Unknow Order Type!";
		}
		return orderTypeName;
	}
}
