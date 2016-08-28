/**
 * 
 */
package com.common.constants;

/**
 *  错误编码和错误描述对应
 * @author zhanghaiyang
 *
 */
public class CodeMsgConstants {

	public static final String code1000 = "1000";
    public static final String message1000 = "服务器操作失败！";

    public static final String code0000 = "2000";
    public static final String message0000 = "OK";

    public static final String code2001 = "2001";
    public static final String message2001 = "传入 待验证参数为空！";
    
    public static final String code2002 = "电子签收码为空！";
    public static final String message2002 = "";
    
    public static final String code2003 = "2003";
    public static final String message2003 = "电子签收码不正确！";
    
    public static final String code2004 = "2004";
    public static final String message2004 = "订单已经验证过了，不能再次验证！";
    
    public static final String code2005 = "2005";
    public static final String message2005 = "该订单未进行验证，请先验证再出库！";
    
    public static final String code2006 = "2006";
    public static final String message2006 = "订单还未支付，不能出库！";
    
    public static final String code2007 = "2007";
    public static final String message2007 = "获取箱数信息为空！";
    
    public static final String code2008 = "2008";
    public static final String message2008 = "订单当前状态不能进行出库操作!";
    
    public static final String code2009 = "2009";
    public static final String message2009= "请扫描箱标签条码!";
    
    public static final String code2010 = "2010";
    public static final String message2010 = "无效的包装条码！";
    
    public static final String code2011 = "2011";
    public static final String message2011 = "该箱不属于该订单！";
    
    public static final String code2012 = "2012";
    public static final String message2012 = "该箱标签已经被重复扫描了！";
    
    public static final String code2013 = "2013";
    public static final String message2013 = "订单箱数已足够，请提交！";
    
    public static final String code2014 = "2014";
    public static final String message2014 = "请扫描下一箱！";
    
    public static final String code2015 = "2015";
    public static final String message2015 = "已扫描箱标签超出该订单实际包装箱数，请确认是否扫描了错误的箱标签！";
    
    public static final String code2016 = "2016";
    public static final String message2016 = "箱标签错误！";
    
    public static final String code2017 = "2017";
    public static final String message2017 = "调整箱标签数据操作失败！";
    
    public static final String code2018 = "2018";
    public static final String message2018 = "请选择需要出库的订单信息!";
    
    public static final String code2019 = "2019";
    public static final String message2019 = "该订单不存在库存信息!";
    
    public static final String code2020 = "2020";
    public static final String message2020 = "自提点库存处理产生异常!";
    
    public static final String code2021 = "2021";
    public static final String message2021 = "商品条码错误！";
    
    public static final String code2022 = "2022";
    public static final String message2022 = "序列号重复扫描！";
    
    public static final String code2023 = "2023";
    public static final String message2023 = "标签处理码与库存处理码不匹配！";
    
    public static final String code2024 = "2024";
    public static final String message2024 = "此商品为二手商品，标签中不含有处理码！";

    public static final String code2025 = "2025";
    public static final String message2025 = "该订单不存在！";
    
    public static final String code2026 = "2026";
    public static final String message2026 = "订单不属于该自提点！";
    
    public static final String code2027 = "2027";
    public static final String message2027 = "订单状态不正确！";
    
    public static final String code2028 = "2028";
    public static final String message2028 = "未订单日结的订单无法出库！";
    
    public static final String code2029 = "2029";
    public static final String message2029 = "输入的订单号为空！";

    public static final String code2030 = "2030";
    public static final String message2030 = "根据录入信息查询订单列表信息为空！";
    
    public static final String code2031 = "2031";
    public static final String message2031 = "商品数量足够，请扫描其它商品！";
    
    public static final String code2032 = "2032";
    public static final String message2032 = "该商品不属于该订单！";
    
    public static final String code2033 = "2033";
    public static final String message2033 = "该输入商品条码！";
    
    public static final String code2034 = "2034";
    public static final String message2034 = "该商品有序列号，请输入序列号！";
    
    public static final String code2035 = "2035";
    public static final String message2035 = "该商品无序列号请去除序列号！";
    
    public static final String code2036 = "2036";
    public static final String message2036 = "该商品序列号不属于该订单！";
    
    public static final String code2037 = "2037";
    public static final String message2037 = "该商品与序列号不匹配！";
    
    public static final String code2038 = "2038";
    public static final String message2038 = "没有可以提交的数据！";
    
    public static final String code2039 = "2039";
    public static final String message2039 = "存在缺失商品，请走线下流程！";
    
    public static final String code2040 = "2040";
    public static final String message2040 = "该订单不属于该站点！";
    
    public static final String code2041 = "2041";
    public static final String message2041 = "该订单和已扫描订单来自不同的主库，不能一起操作！";
    
    public static final String code2042 = "2042";
    public static final String message2042 = "此商品为二手商品，标签中不含有处理码！";
    
    public static final String code2043 = "2043";
    public static final String message2043 = "此商品为正常品，库存中没有处理码，但是标签中含有处理码，请检查！";
    
    public static final String code2044 = "2044";
    public static final String message2044 = "此商品为二手商品，但是库存中没有处理码，请检查！";
    
    public static final String code2045 = "2045";
    public static final String message2045 = "此商品为正常商品，但是库存中含有处理码！";
    
    public static final String code2046 = "2046";
    public static final String message2046 = "扫描条码不允许为空！";
    
    public static final String code2047 = "2047";
    public static final String message2047 = "重复扫描！";
    
    public static final String code2048 = "2048";
    public static final String message2048 = "出库类型为空，请选择转运或者转站出库类型！";
    
    public static final String code2049 = "2049";
    public static final String message2049 = "转站出库操作，请选择出库站点！";
    
    public static final String code2050 = "2050";
    public static final String message2050 = "RPP状态的订单未提交出库！";
    
    public static final String code2051 = "2051";
    public static final String message2051 = "插入Asn信息产生异常！";
    
    public static final String code2052 = "2052";
    public static final String message2052 = "录入的订单不属于该站点！";
    
    public static final String code2053 = "2053";
    public static final String message2053 = "订单状态不是退货订单取货途中！";
    
    public static final String code2054 = "2054";
    public static final String message2054 = "订单状态不是LH或者DF状态！";
    
    public static final String code2055 = "2055";
    public static final String message2055 = "该订单未CLOSE！";
    
    public static final String code2056 = "2056";
    public static final String message2056 = "该站点不是分拨点！";
    
    public static final String code2057 = "2057";
    public static final String message2057 = "无效的订单号码！";
    
    public static final String code2058 = "2058";
    public static final String message2058 = "当前订单已经被派工！";
    
    public static final String code2059 = "2059";
    public static final String message2059 = "无效的派工人员！";
    
    public static final String code2060 = "2060";
    public static final String message2060 = "订单重复扫描！";
    
    public static final String code2061 = "2061";
    public static final String message2061 = "提交失败，不允许选择全部！";
    
    public static final String code2062 = "2062";
    public static final String message2062 = "RPP状态的订单还没有提交！";
    
    public static final String code2063 = "2063";
    public static final String message2063 = "订单状态为DF的订单还未日结！";
    
    public static final String code2064 = "2064";
    public static final String message2064 = "订单状态不是LS或者SA，不能出库！";
    
    public static final String code2065 = "2065";
    public static final String message2065 = "自提点出库失败：订单状态改变发生异常！";
    
    public static final String code2066 = "2066";
    public static final String message2066 = "当前扫描订单同已扫描订单的承运商不同！";
    
    public static final String code2067 = "2067";
    public static final String message2067 = "流水号未输入银行回执单或金额！";
    
    public static final String code2068 = "2068";
    public static final String message2068 = "无效的分拨点！";
    
    public static final String code2069 = "2069";
    public static final String message2069 = "自提点出库失败：自提点出库的库存处理操作发生异常！";
    
    public static final String code2070 = "2070";
    public static final String message2070 = "验证订单操作发生异常！";
    
    public static final String code2071 = "2071";
    public static final String message2071 = "生成派工单号操作发生异常！";
    
    public static final String code2072 = "2072";
    public static final String message2072 = "扫描箱标签时未获取到查询出的订单信息！请再次查询订单号";
    
    public static final String code2073 = "2073";
    public static final String message2073 = "订单查询结果校验发生异常";
    
    public static final String code2074 = "2074";
    public static final String message2074 = "该订单商品标签扫描已经足够";
    
    public static final String code2075 = "2075";
    public static final String message2075 = "该订单商品数已足够，请提交！";
    
    public static final String code2076 = "2076";
    public static final String message2076 = "请录入下一商品信息！";
    
    public static final String code2077 = "2077";
    public static final String message2077 = "已录入商品信息超出该订单实际商品总数，请确认是否录入了错误的商品信息！";
    
    public static final String code2078 = "2078";
    public static final String message2078 = "该订单查询出的电子签收码未缓存，请清除数据后重试！";
    
    public static final String code2079 = "2079";
    public static final String message2079 = "查询出的订单信息列表为空！";
    
    public static final String code2080 = "2080";
    public static final String message2080 = "根据订单号查询出库库存信息发生数据库操作异常！出库操作自提点库存信息处理失败。";
    
    
    //站点部分code&message
    public static final String code3052 = "3052";
    public static final String message3052 = "该ASN不存在或已入库！";
    
    public static final String code3053 = "3053";
    public static final String message3053 = "订单状态修改异常!";

    public static final String code3054 = "3054";
    public static final String message3054 = "更新SC_ASN状态失败！";
    
    public static final String code3055 = "3055";
    public static final String message3055 = "添加站点入库数据失败！";
    
    public static final String code3056 = "3056";
    public static final String message3056 = "添加站点入库详细数据失败！";
    
    public static final String code4001 = "4001";
    public static final String message4001 = "插入超期订单履历表失败！";
    
    public static final String code4002 = "4002";
    public static final String message4002 = " 插入自提点入库信息失败！";
    
    public static final String code4003 = "4003";
    public static final String message4003 = " 插入自提点入库详细信息失败！";
    
    public static final String code4004 = "4004";
    public static final String message4004 = " 插入自提点入库序列失败！";
    
}
