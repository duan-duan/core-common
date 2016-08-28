/**
 * 
 */
package com.common.web.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.constants.Constants;
import com.common.entity.BaseEntity;
import com.common.exception.BaseException;
import com.common.service.BaseService;
import com.common.util.LogTracking;
import com.common.web.sort.EntitySort;
import com.common.web.springmvc.DateTypeEditor;
import com.common.web.springmvc.MessageResolver;
import com.common.web.util.ResponseWorker;
import com.google.common.collect.Maps;

/**
 * @author huanggaoren
 * 
 */
public abstract class BaseCRUDAction<T extends BaseEntity, ID extends Serializable>
		extends BaseAction<T, ID> {

	public abstract BaseService<T, ID> getBaseService();

	/**
	 * 列表 GET 获取页面 list.htm
	 * 
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return viewName("list");
	}

	/**
	 * json列表 POST 获取数据 list.json
	 * 
	 * @param response
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> list(Long page, Integer rows, T t,
			String sort, String order) {
		Map<String, Object> map = Maps.newHashMap();
		try {
			EntitySort<T>	es=new EntitySort<T>(t);
			sort=es.getDBField(t,sort);
			map = this.getBaseService().pageQueryEntity(page, rows, t, sort,
					order);
		} catch (Exception e) {
			e.printStackTrace();
			LogTracking.errorLog(this.getClass(), "list", e.getMessage());
		}
		return map;
	}

	/**
	 * 列表 GET 获取Tree页面 tree.htm
	 * 
	 * @return
	 */
	@RequestMapping(value = "tree", method = RequestMethod.GET)
	public String tree() {
		return viewName("tree");
	}

	/**
	 * 查找出所有的数据 listAll.htm
	 * 
	 * @return
	 */
	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	public @ResponseBody List<T> queryList() {
		return this.getBaseService().queryList();
	}

	/**
	 * 
	 * @Title: save
	 * @Description: TODO保存对象
	 * @param
	 * @param entity
	 * @param
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> create(
			final HttpServletRequest request, T t) { // @RequestBody
		LogTracking.debugLog(this.getClass(), "create", "create bean");
		final Map<String, Object> map = Maps.newHashMap();
		try {
			setDefaultValue(request, t, "create");// 临时设置默认值
			final int i = this.getBaseService().createEntity(t);
			ResponseWorker<T> worker = new ResponseWorker<T>() {
				@Override
				protected Map<String, Object> processMsg() throws Exception {
					if (i > 0) {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.SUCCESS_SAVE));
						map.put("state", Constants.State.TRUE);
					} else {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.FAILED_SAVE));
						map.put("state", Constants.State.FALSE);
					}
					return map;
				}
			};
			return worker.execute();
		} catch (BaseException e) {
			e.printStackTrace();
			map.put("msg", MessageResolver.getMessage(request,
					Constants.Message.FAILED_SAVE));
			map.put("state", Constants.State.FALSE);
			LogTracking.errorLog(this.getClass(), "create", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogTracking.debugLog(this.getClass(), "create", "create end");
		return map;
	}

	/***
	 * 
	 * @Title: updateT
	 * @Description: TODO 更新
	 * @param @param entity
	 * @param @param request
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> update(
			final HttpServletRequest request, T t) { // @RequestBody
		final Map<String, Object> map = Maps.newHashMap();
		try {
			setDefaultValue(request, t, "update");// 临时设置默认值
			final int i = this.getBaseService().updateEntity(t);
			ResponseWorker<T> worker = new ResponseWorker<T>() {
				@Override
				protected Map<String, Object> processMsg() throws Exception {
					if (i > 0) {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.SUCCESS_UPDATE));
						map.put("state", Constants.State.TRUE);
					} else {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.FAILED_UPDATE));
						map.put("state", Constants.State.FALSE);
					}
					return map;
				}

			};
			return worker.execute();
		} catch (BaseException e) {
			e.printStackTrace();
			map.put("msg", MessageResolver.getMessage(request,
					Constants.Message.FAILED_UPDATE));
			map.put("state", Constants.State.FALSE);
			LogTracking.errorLog(this.getClass(), "update", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws delete.htm
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(
			final HttpServletRequest request, ModelMap model, ID id) {
		final Map<String, Object> map = Maps.newHashMap();
		try {
			final int i = this.getBaseService().deleteById(id);
			ResponseWorker<T> worker = new ResponseWorker<T>() {
				@Override
				protected Map<String, Object> processMsg() throws Exception {
					if (i > 0) {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.SUCCESS_DELETE));
						map.put("state", Constants.State.TRUE);
					} else {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.FAILED_DELETE));
						map.put("state", Constants.State.FALSE);
					}
					return map;
				}

			};
			return worker.execute();
		} catch (BaseException e) {
			e.printStackTrace();
			map.put("msg", MessageResolver.getMessage(request,
					Constants.Message.FAILED_DELETE));
			map.put("state", Constants.State.FALSE);
			LogTracking.errorLog(this.getClass(), "delete", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: deleteByIds
	 * @Description: TODO 批量刪除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteByIds", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteByIds(
			final HttpServletRequest request, ModelMap model,
			@RequestParam("ids[]") ID ids[]) {
		final Map<String, Object> map = Maps.newHashMap();
		try {
			final int i = this.getBaseService().deleteByIds(ids);
			ResponseWorker<T> worker = new ResponseWorker<T>() {
				@Override
				protected Map<String, Object> processMsg() throws Exception {
					if (i > 0) {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.SUCCESS_DELETE));
						map.put("state", Constants.State.TRUE);
					} else {
						map.put("msg", MessageResolver.getMessage(request,
								Constants.Message.FAILED_DELETE));
						map.put("state", Constants.State.FALSE);
					}
					return map;
				}
			};
			return worker.execute();
		} catch (BaseException e) {
			e.printStackTrace();
			map.put("msg", MessageResolver.getMessage(request,
					Constants.Message.FAILED_DELETE));
			map.put("state", Constants.State.FALSE);
			LogTracking
					.errorLog(this.getClass(), "deleteByIds", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * 
	 * @Title: unqiue
	 * @Description: TODO 验证唯一性
	 * @param @param v unqiue.json
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/unique", method = RequestMethod.POST)
	public @ResponseBody boolean unqiue(T t) { // @RequestBody
												// 接收json字符串非json对象，放在对象前
		try {
			Long count = this.getBaseService().pageQueryEntityCount(t);
			if (count != null && count > 0) { // 为false 返回存在
				return false;
			}
		} catch (BaseException e) {
			e.printStackTrace();
			LogTracking.errorLog(this.getClass(), "unqiue", e.getMessage());
		}
		return true;
	}

	/**
	 * 返回编辑详细页面 edit.htm
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public @ResponseBody String view(Long page, Integer rows, Model model) {
		model.addAttribute("page", page);
		model.addAttribute("rows", rows);
		return viewName("edit");
	}

	/**
	 * 根据ID获取对象 edit.json
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody T get(ID id) {
		return this.getBaseService().queryById(id);
	}

	/**
	 * 设置对象的默认值
	 * 
	 * @param t
	 *            类
	 * @param operateFlag
	 *            操作标识 create or update
	 */
	protected abstract void setDefaultValue(HttpServletRequest request, T t,
			String operateFlag);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTypeEditor());
	}
}
