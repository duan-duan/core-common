/**
 * 
 */
package com.common.web.freemarker;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.common.web.freemarker.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateSequenceModel;
import freemarker.template.TemplateScalarModel;

/**
 * @author huanggaoren
 *
 */
public class PermistionDirective implements TemplateDirectiveModel {

	public static final String PERMISSION_MODEL = "_permission_key";

	/**
	 * 此url必须和perm中url一致。
	 */
	public static final String PARAM_URL = "url";
	
	/**
	 * 授权 暂时未实现这块
	 */
	public static final String PERMISSION="permission";

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// perms为null代表无需控制权限。
		String url = DirectiveUtils.getString(PARAM_URL, params);
		
		// 暂时未实现这块
		//String permission = DirectiveUtils.getString(PERMISSION, params);
		
		boolean pass = false;
		if (StringUtils.isBlank(url)) {
			// url为空，则认为无权限。
			pass = true;
		} else {
			TemplateSequenceModel perms = getPerms(env);
			if (perms == null) {
				// perms为null，则代表不需要判断权限。
				pass = true;
			} else {
				String perm;
				for (int i = 0, len = perms.size(); i < len; i++) {
					perm = ((TemplateScalarModel) perms.get(i)).getAsString();
					if (url.startsWith(perm)) {
						pass = true;
						break;
					}
				}
			}
		}
		if (pass) {
			body.render(env.getOut());
		}

	}

	/**
	 * 获取参数
	 * 
	 * @param env
	 * @return
	 * @throws TemplateModelException
	 */
	private TemplateSequenceModel getPerms(Environment env)
			throws TemplateModelException {
		TemplateModel model = env.getDataModel().get(PERMISSION_MODEL);
		if (model == null) {
			return null;
		}
		if (model instanceof TemplateSequenceModel) {
			return (TemplateSequenceModel) model;
		} else {
			throw new TemplateModelException(
					"'perms' in data model not a TemplateSequenceModel");
		}

	}
}
