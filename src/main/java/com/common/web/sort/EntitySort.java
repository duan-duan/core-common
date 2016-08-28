/**   
 * @Title: EntitySort.java 
 * @Package com.gome.common.web.sort 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author huanggaoren
 * @E-mail itorac@sina.com.cn   
 * @date 2015年1月21日 上午11:30:56 
 * @version V1.0.0 
 */
package com.common.web.sort;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;

/**
 * @ClassName: EntitySort
 * @Description: TODO 实体排序Map
 * @author huanggaoren
 * @E-mail itorac@sina.com.cn
 * @date 2015年1月21日 上午11:30:56
 * 
 */
public class EntitySort<T> {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public EntitySort() {

	}

	/**
	 * 
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param t
	 */
	public EntitySort(T t) {
	}

	/**
	 * 
	 * @Title: getDBKey
	 * @Description: TODO 根据传输过来的ID找到数据库中对应的字段
	 * @param @param field
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getDBField(T t, String field) {

		Map<String, String> fieldMap = Maps.newHashMap();
		if (t != null) {
			String siampleName = t.getClass().getSimpleName();
			if (StringUtils.isNotEmpty(siampleName)) {
				if (siampleName.equalsIgnoreCase("User")) {
					fieldMap.put("id", "su_id");
					fieldMap.put("account", "su_account");
				} else if (siampleName.equalsIgnoreCase("Role")) {
					fieldMap.put("id", "sr_id");
					fieldMap.put("name", "sr_name");
				} else if (siampleName.equalsIgnoreCase("LoginFailLog")) {
					fieldMap.put("insertDate", "insert_date");
				} else if (siampleName.equalsIgnoreCase("LoginSuccessLog")) {
					fieldMap.put("insertDate", "insert_date");
				} else if (siampleName.equalsIgnoreCase("OperationLog")) {
					fieldMap.put("insertDate", "insert_date");
				} else if (siampleName.equalsIgnoreCase("DataDictionary")) {
					fieldMap.put("englishName", "ENGLISH_NAME");
					fieldMap.put("indicateName", "INDICATE_NAME");
				} else if (siampleName.equalsIgnoreCase("CarInfo")) {
					fieldMap.put("carNo", "CAR_NO");
					fieldMap.put("carCardId", "CAR_CARD_ID");
					fieldMap.put("carLsp", "CAR_LSP");
					fieldMap.put("carBuyingTime", "CAR_BUYINGTIME");
					fieldMap.put("defaultDriver", "DEFAULT_DRIVER");
					fieldMap.put("carModel", "CAR_MODEL");
					fieldMap.put("carLeaveFactoryDate", "CAR_LEAVEFACTORY_DATE");
					fieldMap.put("productionCompany", "PRODUCTION_COMPANY");
					fieldMap.put("carBoxLength", "CAR_BOX_LENGTH");
					fieldMap.put("carIsActivity", "CAR_ISACTIVITY");
				} else if (siampleName.equalsIgnoreCase("DriverInfo")) {
					fieldMap.put("driverNo", "DRIVER_NO");
					fieldMap.put("driverName", "DRIVER_NAME");
					fieldMap.put("driverLsp", "DRIVER_LSP");
					fieldMap.put("driverDepartment", "DRIVER_DEPARTMENT");
					fieldMap.put("driverCard", "DRIVER_CARD");
					fieldMap.put("driverIdCard", "DRIVER_IDCARD");
					fieldMap.put("driverPhone", "DRIVER_PHONE");
					fieldMap.put("driverLevel", "DRIVER_LEVEL");
					fieldMap.put("driverSkillLevel", "DRIVER_SKILL_LEVEL");
					fieldMap.put("driverCarType", "DRIVER_CAR_TYPE");
					fieldMap.put("driverIsActivity", "DRIVER_ISACTIVITY");
				} else if (siampleName.equalsIgnoreCase("MstLsp")) {
					fieldMap.put("lspName", "LSP_NAME");
					fieldMap.put("lspCode", "LSP_CODE");
					fieldMap.put("codRate", "COD_RATE");
					fieldMap.put("insuranceRate", "INSURANCE_RATE");
					fieldMap.put("lspContact", "LSP_CONTACT");
					fieldMap.put("lspPhone", "LSP_PHONE");
				}else if (siampleName.equalsIgnoreCase("MasLoc")) {
					fieldMap.put("masLoc", "MAS_LOC");
				}
			}
		}
		return fieldMap.get(field);
	}
}
