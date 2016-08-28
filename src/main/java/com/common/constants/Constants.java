/**
 * 
 */
package com.common.constants;

/**
 * @author huanggaoren
 *
 */
public interface Constants {

	/**
	 * 逻辑
	 * 
	 * @author huanggaoren
	 *
	 */
	public class State {
		/**
		 * FALSE
		 */
		public final static Boolean FALSE = false;

		/**
		 * TRUE
		 */
		public final static Boolean TRUE = true;
	}

	/**
	 * 模板
	 * 
	 * @author huanggaoren
	 *
	 */
	public class Report {

		/**
		 * 模板 ID
		 */
		public final static String REPORT_ID = "REPORT_ID";

		/**
		 * 模板路径
		 */
		public final static String FTL_PATH = "FTL_PATH";

		/**
		 * 文件后缀
		 */
		public final static String SUFFIX = ".ftl";

	}

	// 业务类别
	public static class File {
		public static char separator_cmn = ',';
		// 分隔符号
		public static char separator = '^';
		// 分隔符号
		public static char SEPARATOR_YTFH = ',';
		// 分隔符号
		public static char SEPARATOR_EMS = ',';

		public static char TAB_SEPARATOR = '\t';
		// 分隔符号
		public static String file_separator = "/";
		// 文件名称字符集
		public static String encoding_filename_gbk = "GBK";
		// CSV转换字符集
		public static String encoding_csv_gbk = "GBK";
		public static String suffix_csv = ".CSV";// 查找文件的扩展名
		public static String SUFFIX_PDF = ".PDF";// 查找文件的扩展名
		public static String suffix_xiao_csv = ".csv";// 查找文件的扩展名
		public static String filename_tmp = "_TMP";// 查找文件的扩展名
		public static String filename_bak = "_BAK";// 查找文件的扩展名
		public static String filename_err = "_ERR";// 查找文件的扩展名
		// public static int file_max_count = 10;// 最大可改变文件数
		public static int BASE_COUNT = 25; // 每次读取文件的个数，此为基础值
	}

	// 业务类别
	public static class FTPFILEPATH {
		public static String WORK_DIR = "WORKING";// 发送文件和读取文件的文件夹
		public static String BACKUP_DIR = "BACKUP";// 备份文件的文件夹
		public static String ERROR_DIR = "ERROR";// 发送文件和读取文件的文件夹

		public static String FILE_PDF = "PDF";// 发送文件和读取文件的文件夹

		public static String PREORDER_DIR = "PREORDER";// 预订单
		public static String ORDEREXACT_DIR = "ORDEREXACT";// 正式订单
		public static String ORDERNUMRELATION_DIR = "ORDERNUMRELATION";// 回传订单和运单号匹配信息
		public static String DELIVERYTNT_DIR = "DELIVERYTNT";// 回传订单状态
		public static String ORDERCHANGE_DIR = "ORDERCHANGE";// 发送订单状态改变信息
		public static String EXITORDER_DIR = "EXITORDER";// 发送退订单信息

	}

	public static class InceptState {

		public static final Object DF = "DF";

	}

	/**
	 *
	 * 业务类别
	 *
	 * @author
	 */
	public static class OPERATIONTYPE {

		/**
		 * 状态值的代码
		 */
		public static class Code {

			/** 预发送订单（预ASN） */
			public static final String PREORDER = "1";

			/** 筛单 */
			// public static final String PREORDERTNT = "2";

			/** 发送正式订单（ASN）就是双方签字后的一单信息 */
			public static final String ORDEREXACT = "3";

			/** 回传订单和运单号匹配信息 */
			public static final String ORDERNUMRELATION = "4";

			/** 回传订单状态 */
			public static final String DELIVERYTNT = "5";
			/**
			 * 发送订单状态改变信息
			 */
			public static final String ORDERCHANGE = "6";
			/**
			 * 发送退货订单状态改变信息
			 */
			public static final String EXITORDER = "7";

			public static String[] getAllCode() {
				String[] code = { PREORDER, ORDEREXACT, ORDERNUMRELATION,
						DELIVERYTNT, ORDERCHANGE, EXITORDER };
				return code;
			}
		}

		/**
		 * 状态值的名称
		 */
		public static class Name {
			/** 预发送订单（预ASN） */
			public static final String PREORDER = "PREORDER";

			/** 筛单 */
			// public static final String PREORDERTNT = "2";

			/** 发送正式订单（ASN）就是双方签字后的一单信息 */
			public static final String ORDEREXACT = "ORDEREXACT";

			/** 回传订单和运单号匹配信息 */
			public static final String ORDERNUMRELATION = "ORDERNUMRELATION";

			/** 回传订单状态 */
			public static final String DELIVERYTNT = "DELIVERYTNT";
			/**
			 * 发送订单状态改变信息
			 */
			public static final String ORDERCHANGE = "ORDERCHANGE";
			/**
			 * 发送订单状态改变信息
			 */
			public static final String EXITORDER = "EXITORDER";

			public static String[] getAllName() {
				String[] name = { PREORDER, ORDEREXACT, ORDERNUMRELATION,
						DELIVERYTNT, ORDERCHANGE, EXITORDER };
				return name;
			}
		}

		public static String getNameByCode(String code) {
			String name = ""; // 返回的名称
			String[] allCode = Code.getAllCode(); // 所有代码
			for (int n = 0; n < allCode.length; n++) {
				if (allCode[n].equals(code)) {
					name = Name.getAllName()[n];
					break;
				}
			}
			return name;
		}
	}

	public class Operator {

		/**
		 * 创建
		 */
		public final static String CREATE = "创建";

		/**
		 * 更新
		 */
		public final static String UPDATE = "更新";

		/**
		 * 删除
		 */
		public final static String DELETE = "删除";
	}

	/**
	 * 操作信息
	 * 
	 * @author huanggaoren
	 *
	 */
	public class Message {
		/**
		 * 保存成功
		 */
		public static final String SUCCESS_SAVE = "global.success.save";

		/**
		 * 保存失败
		 */
		public static final String FAILED_SAVE = "global.failed.save";

		/**
		 * 更新成功
		 */
		public static final String SUCCESS_UPDATE = "global.success.update";

		/**
		 * 更新失败
		 */
		public static final String FAILED_UPDATE = "global.failed.update";
		
		
		/**
		 * 激活成功
		 */
		public static final String SUCCESS_ACTIVATE = "global.success.activate";

		/**
		 * 激活失败
		 */
		public static final String FAILED_ACTIVATE = "global.failed.activate";

		

		/**
		 * 删除成功
		 */
		public static final String SUCCESS_DELETE = "global.success.delete";

		/**
		 * 删除失败
		 */
		public static final String FAILED_DELETE = "global.failed.delete";
	}
	
	/**
	 * ASN制单状态
	 * author:gqs
	 */
	public class AsnStatus{
		public final static String NEW = "NEW";
		
		public final static String SHIPMENT = "SHIPPED";
		
		public final static String CANCEL = "CANCEL";
		
		public final static String PARTICAL = "PARTICAL";
		 
		public final static String COMPLETED = "COMPLETED";
	}
	
	/**
	 * 箱完整与否
	 * author:gqs
	 */
	public class BoxStatus{
		public static final String LACK_FLAG_YES = "Y";//完整
		public static final String LACK_FLAG_NO = "N";//缺失
		public static final String LACK_FLAG_DAMAGE = "D";	//破损
	}
	
	
	/**
	 * 打印文件属性文件
	 * 
	 * @author huanggaoren
	 *
	 */
	public class print {

		/**
		 * 模板后缀
		 */
		public final static String PRINT_TEMPLATE_SUFFIX = ".jasper";

		/**
		 * 打印模板路径
		 */
		public final static String PRINT_TEMPLATE_PATH = "print_template_path";
		
		/**
		 * 配置文件
		 */
		public static final String DEFAULT_PROPERTY_FILE = "printConfig.xml";
	}
	
	/**
	 * 运单财务审批状态
	 * @author guoqiushi
	 *
	 */
	public class FBFinancialAuditStatus {

	    public final static String PASS = "Y";
	    
	    public final static String NOT_PASS = "N";
	    
	    public final static String UNAUDITED = "U";
	}
	
	/**
	 * 派工状态
	 * @author guoqiushi
	 *
	 */
	public static class DeliveryStatus {
		public final static String NEW = "NEW";
		public final static String EX_SC = "EX-SC";
		public final static String COMPLETE = "COMPLETE";
		public final static String PARTIAL_COMPLETE = "PARTIAL_COMPLETE";
	}
	
	/**
	 * 
	 * @ClassName: HubType 
	 * @Description: 仓库类型
	 * @author lianzhiqiang
	 * @date 2014年11月17日 上午11:50:35 
	 *
	 */
	public static class HubType {
		public final static String THREEPL_SC = "3PLSC";
		public final static String THREEPP = "3PL";
		public final static String SC = "SC";
		public final static String SMI = "SMI";
		public final static String THREE_PP ="3PP";
		public final static String SP ="SP";
	}	
}
