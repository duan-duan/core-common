/**
 * 
 */
package com.common.web.controller;

import static com.common.util.StringUtil.spilt;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.web.springmvc.ReadPropertyPlaceholderConfigurer;

/**
 * @author huanggaoren
 * 
 */
public abstract class BaseAction<T, ID extends Serializable> {

	/**
	 * 
	 * 视图的前缀
	 */
	private String viewPrefix;

	protected BaseAction() {
		setViewPrefix(defaultViewPrefix());
	}

	/**
	 * 添加Model消息
	 * 
	 * @param message
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		model.addAttribute("message", sb.toString());
	}

	/**
	 * 当前模块 视图的前缀 默认 1、获取当前类头上的@RequestMapping中的value作为前缀 2、如果没有就使用当前模型小写的简单类名
	 */
	public void setViewPrefix(String viewPrefix) {
		if (viewPrefix.startsWith("/")) {
			viewPrefix = viewPrefix.substring(1);
		}
		this.viewPrefix = viewPrefix;
	}

	public String getViewPrefix() {
		return viewPrefix;
	}

	/**
	 * 获取视图名称：即prefixViewName + "/" + suffixName
	 * 
	 * @return
	 */
	public String viewName(String suffixName) {
		if (!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}
		return getViewPrefix() + suffixName;
	}

	/**
	 * @param backURL
	 *            null 将重定向到默认getViewPrefix()
	 * @return
	 */
	protected String redirectToUrl(String backURL) {
		if (!StringUtils.isEmpty(backURL)) {
			if (!backURL.startsWith("/") && !backURL.startsWith("http")) {
				backURL = "/" + backURL;
			}
			if (backURL.startsWith("http")) {
				return "redirect:" + backURL;
			}
			backURL = "/" + getViewPrefix() + backURL;
		}
		return "redirect:" + backURL;
	}

	/**
	 * @param backURL
	 *            null 将重定向到默认getViewPrefix()
	 * @return
	 */
	protected String redirectLoginToUrl() {
		return "redirect:"
				+ ReadPropertyPlaceholderConfigurer
						.getContextProperty("login.url");
	}

	/**
	 * 
	 * @Title: defaultViewPrefix
	 * @Description: TODO 默认试图前缀
	 * 
	 * @param
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	protected String defaultViewPrefix() {
		String currentViewPrefix = "";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(
				getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			currentViewPrefix = requestMapping.value()[0];
		}
		String newCurrentViewPrefix = "";
		if (StringUtils.isNotEmpty(spilt(currentViewPrefix, 1))) {
			newCurrentViewPrefix = newCurrentViewPrefix + "/"
					+ spilt(currentViewPrefix, 1);
		}
		if (StringUtils.isNotEmpty(spilt(currentViewPrefix, 2))) {
			newCurrentViewPrefix = newCurrentViewPrefix + "/"
					+ spilt(currentViewPrefix, 2);
		}
		return newCurrentViewPrefix;
	}
}
