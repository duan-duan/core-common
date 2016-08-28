package com.common.util;

/**
 * 返回结果类
 * @author guoqiushi
 *
 */
public class SimpleResponse extends BaseResponse{
	
	private static final long serialVersionUID = 1L;
	private static SimpleResponse simpleResponse = new SimpleResponse();
	
	public static SimpleResponse getInstance(){
		return simpleResponse;
	}
	
	private SimpleResponse() {
	}

    /**
	 * 总件数
	 */
    private long totalBoxQty;
 
    /**
     * 总订单数
     */
    private long totalOrderQty;
    
    /**
     * 总已扫描件数
     */
    private long totalScanBoxQty; 
    
    
	public long getTotalBoxQty() {
		return totalBoxQty;
	}

	public void setTotalBoxQty(long totalBoxQty) {
		this.totalBoxQty = totalBoxQty;
	}

	public long getTotalOrderQty() {
		return totalOrderQty;
	}

	public void setTotalOrderQty(long totalOrderQty) {
		this.totalOrderQty = totalOrderQty;
	}

	public long getTotalScanBoxQty() {
		return totalScanBoxQty;
	}

	public void setTotalScanBoxQty(long totalScanBoxQty) {
		this.totalScanBoxQty = totalScanBoxQty;
	}

	@Override
	public String toString() {
		return JsonUtil.objectToJSON(this);
	}
      
}
