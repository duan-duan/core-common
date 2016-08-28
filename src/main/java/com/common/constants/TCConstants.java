/**
 * 
 */
package com.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Linfeng_Li
 * @Desc Three C 
 */
public interface TCConstants {

	/**
	 * 
	 * @Author Linfeng_Li
	 *
	 */
	public class TNT_STATE {
		public final static String CO = "CO";
		public final static String OD = "OD";
		public final static String OD_DESC = "订单下载";
		public final static String PR = "PR";
		public final static String PR_DESC = "分配承运商";
		public final static String PP = "PP";
		public final static String BP = "BP";
		public final static String BP_DESC = "订单已制单";
		public final static String SC = "SC";
		public final static String PC = "PC";
		public final static String PC_DESC = "订单包装";
		public final static String EX = "EX";
		public final static String EX_DESC = "订单已出库";
		public final static String ROA = "ROA";
		public final static String MSC = "MSC";
		public final static String MSC_DESC = "丢包";
		public final static String MS = "MS";
	}

	/**
	 * @Author Linfeng_Li
	 *
	 */
	public class TNT {

		
		/**集团3C项目调TNT时PartnerCode值*/
		public final static String PARTNER_CODE = "DRGONG3C";
		/**门店3C项目调TNT时PartnerCode值*/
		public final static String STORE_PARTNER_CODE = "DRG_3C";
		/**TNT转发出去的PartnerCode*/
		public final static String TNT_PARTNER_CODE = "DRG_3C";
		
		public final static String BUID = "8270";
		/**集团订单状态来源*/
		public final static String HQSAP_ORDER = "HQSAP";
		/**LSP订单状态来源*/
		public final static String LSP_ORDER = "LSP";
		/**初始化statecode对应的statename*/
		public final static Map<String, String> stateCodeMapping = new HashMap<String, String>();
		
		static {
			initStateCodeMapping();
		}
		
		public static void initStateCodeMapping(){
			stateCodeMapping.put("CL", "订单取消");
			stateCodeMapping.put("RT", "订单拒收入库");
			stateCodeMapping.put("EX", "订单出库");
			stateCodeMapping.put("ROA", "逆向订单接收");
			stateCodeMapping.put("MSC", "订单丢包确认");
			stateCodeMapping.put("MS", "丢包");
		}
	}
	
}
