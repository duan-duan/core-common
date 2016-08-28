package com.common.util;

/**
 * 
 * @author guoqiushi
 *
 */
public enum ReturnCode {

	SUCCESS("SUCCESS","成功"),
	NO_DATA_FOUND("NO_DATA_FOUND","未发现数据"),
	PLS_SCAN_BOXLABEL("PLS_SCAN_BOXLABEL","请扫描箱标签"),
	PLS_SCAN_ORD_NUM("PLS_SCAN_ORD_NUM","未扫描这个订单"),
	NOT_CURRENT_ORDER("NOT_CURRENT_ORDER","该箱不属于当前订单"),
	INVALID_ORDER_STATUS("INVALID_ORDER_STATUS","订单状态不正确"),
	ORDER_MUST_BELONG_MASLOC("ORDER_MUST_BELONG_MASLOC","该订单不属于该自提点"),
	ORDER_MUST_BELONG_SITE("ORDER_MUST_BELONG_SITE","该订单不属于该分拨点"),
	INVALID_BOX_ID("INVALID_BOX_ID","无效的箱号"),
	CURBOXID_IS_SCANNED("CURBOXID_IS_SCANNED","箱号重复扫描"),
	BOX_LABEL_ERROR("BOX_LABEL_ERROR","箱标签格式错误"),
	BOX_LABEL_NOT_BELONG_ORDER("BOX_LABEL_NOT_BELONG_ORDER","箱标签不属于该订单"),
	BOX_LABEL_REPEAT_SCAN("BOX_LABEL_REPEAT_SCAN","箱标签重复扫描"),
	SCAN_BOX_NUM_BEYONG("SCAN_BOX_NUM_BEYONG","超出该订单包裹数"),
	ENOUGH_BOXES("ENOUGH_BOXES","该订单下所有商品扫描完毕，进入下一订单"),
	NEXT_BOXES("NEXT_BOXES","请扫描下一箱"),
	PART_LABEL_ERROR("PART_LABEL_ERROR","商品条码错误"),
	PART_LABEL_NOT_BELONG_ORDER("PART_LABEL_NOT_BELONG_ORDER","该商品不属于该订单"),
	PROCESS_CODE_NOT_MATCH("PROCESS_CODE_NOT_MATCH","标签处理码与库存处理码不匹配"),
	ISUSED_PROCESS_CODE_NOT("ISUSED_PROCESS_CODE_NOT","此商品为二手商品，标签中不含有处理码"),
	ISUSED_STORE_LABEL_PROCESSCODE_NULL("ISUSED_STORE_LABEL_PROCESSCODE_NULL","此商品为二手商品，标签和库存均不含有处理码"),
	ISUSED_STORE_PROCESSCODE_NULL("ISUSED_STORE_PROCESSCODE_NULL","此商品为二手商品，标签含有处理码，库存不含有处理码"),
	ISUSED_LABEL_PROCESSCODE_NULL("ISUSED_LABEL_PROCESSCODE_NULL","此商品为二手商品，标签中不含有处理码，库存中含有处理码"),
	UNUSED_LABEL_PROCESSCODE_EXIST("UNUSED_LABEL_PROCESSCODE_EXIST","此商品为正常品，标签中含有处理码，请检查！"),
	UNUSED_STORE_PROCESSCODE_EXIST("UNUSED_STORE_PROCESSCODE_EXIST","此商品为正常品，标签中不含有处理码，库存中含有处理码，请检查！"),
	PART_BATCH_NOT_BELONG_ORDER("PART_BATCH_NOT_BELONG_ORDER","该商品批次不属于该订单"),
	PART_SERIAL_NOT_BELONG_ORDER("PART_SERIAL_NOT_BELONG_ORDER","该商品序列号不属于该订单"),
	SERIALS_REPEAT("SERIALS_REPEAT","序列号重复扫描"),
	ENOUGH_PARTS("ENOUGH_PARTS","该订单下所有商品扫描完毕，进入下一订单"),
	PART_SERIAL_NOT_BELONG_BATCH("PART_SERIAL_NOT_BELONG_BATCH","该商品序列号不属于该批次"),
	PART_NEXT("PART_NEXT","请扫下一件商品"),
	PART_NUM_IS_NOT_NULL("PART_NUM_IS_NOT_NULL","商品编码不能为空"),
	PLS_IN_SERIAL("PLS_IN_SERIAL","该商品有序列号，请输入商品序列号"),
	PLS_OUT_SERIAL("PLS_OUT_SERIAL","该商品无序列号,请去除序列号"),
	PART_SERIAL_NOT_MATCH("PART_SERIAL_NOT_MATCH","商品与序列号不匹配"),
	NO_DATA_SUBMIT("NO_DATA_SUBMIT","前台无数据提交，请提交数据"),
	ORDER_IS_INCOMPLETE("ORDER_IS_INCOMPLETE","存在缺失商品，请走线下流程"),
	PLS_INPUT_LSP("PLS_INPUT_LSP","请选择承运商"),
	PLS_INPUT_MASLOC("PLS_INPUT_MASLOC","请选择自提点"),
	LSP_CODE_SCAN_COMPLETE("LSP_CODE_SCAN_COMPLETE","该承运商下的订单已扫描完成"),
	SPL_ORDER_INCOMPLETE("SPL_ORDER_INCOMPLETE","自提收货订单货箱存在破损或丢失"),
	SC_ORDER_INCOMPLETE("SC_ORDER_INCOMPLETE","站点收货订单货箱存在破损或丢失"),
	PLS_INPUT_USERNAME("PLS_INPUT_USERNAME","请输入用户名"),
	PLS_INPUT_PASSWORD("PLS_INPUT_PASSWORD","请输入密码"),
	USER_NOT_EXSIT("USER_NOT_EXSIT","用户不存在"),
	USER_IS_INVALID("USER_IS_INVALID","该用户无效"),
	ORDER_NOT_EXIST("ORDER_NOT_EXIST","订单号不存在"),
	NO_PERMISSION("NO_PERMISSION","没有权限"),
	FORCE_BROKEN_OR_LACK_FAIL("FORCE_BROKEN_OR_LACK_FAIL","授权报损或授权报缺"),
	QUTHORIZE_SUCCESS("QUTHORIZE_SUCCESS","授权成功，可以提交"),
	POD_STATUS_CANNOT_RV("POD_STATUS_CANNOT_RV","POD状态订单不能拒收"),
	SESSION_NOT_FOUND("SESSION_NOT_FOUND","未获取到session"),
	RECORD_EXIST("RECORD_EXIST","该条记录已存在"),
	PICKUP_RECORD_EXIST("PICKUP_RECORD_EXIST","该自提点以及对应的承运商信息已存在"),
	DIVISION_EXIST("DIVISION_EXIST","该区域信息已存在"),
	BACK_HANDLE_ERROR("BACK_HANDLE_ERROR","后台处理发生异常");
	
	/****************************************************/
	
	private String code;
	private String text;

	private ReturnCode(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String code() {
		return code;
	}

	public String text() {
		return text;
	}

    public static String codeToMsg(ReturnCode code) {
        return ReturnCode.codeToMsg(code.code());
    }

    public static String codeToMsg(String code) {
        for (ReturnCode e : ReturnCode.values()) {
            if (e.code().equalsIgnoreCase(code)) {
                return e.text();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
