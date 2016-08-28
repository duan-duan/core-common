/**
 * 
 */
package com.common.web.util;

import java.util.Map;

/**
 * @author huanggaoren
 *
 */
public abstract class ResponseWorker<T> {

	public ResponseWorker() {

	}

	protected abstract Map<String, Object> processMsg() throws Exception;

	public Map<String, Object> execute() throws Exception {
		return processMsg();
	}
}
