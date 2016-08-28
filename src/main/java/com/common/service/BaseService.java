/**
 * 
 */
package com.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.common.entity.BaseEntity;

/**
 * @author huanggaoren
 * 
 */
public interface BaseService<T extends BaseEntity, ID extends Serializable> {

	/**
	 * 增加
	 * 
	 * @param t
	 */
	public int createEntity(T t);

	/**
	 * 更新
	 * 
	 * @param t
	 */
	public int updateEntity(T t);

	/**
	 * 根据ID删除对象
	 * 
	 * @param id
	 */
	public int deleteById(ID id);

	/**
	 * 根据ID数组删除对象
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByIds(ID[] ids);

	/**
	 * 根据实体删除对象
	 * 
	 * @param t
	 * @return
	 */
	public int deleteByObject(T t);

	/**
	 * 根据id找到对象
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(ID id);

	/**
	 * 根据参数对象查询对象
	 * 
	 * @param t
	 * @return
	 */
	public T queryByEntity(T t);

	/**
	 * 根据Map查询对象
	 * 
	 * @param t
	 * @return
	 */
	public T queryByMap(Map<String, String> map);

	/**
	 * 查询所有数据列表
	 * 
	 * @return
	 */
	public List<T> queryList();

	/**
	 * 根据实体来查询List列表
	 * 
	 * @return
	 */
	public List<T> queryListByEntity(T t);

	/**
	 * 根据Map参数来查询
	 * 
	 * @param map
	 * @return
	 */
	public List<T> queryListByMap(Map<String, String> map);

	/**
	 * 分页查询
	 * <p>
	 * 不带参数查询分页
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> pageQueryEntity(Long page, Integer rows);

	/**
	 * 分页查询
	 * <p>
	 * 带参数，默认排序
	 * </P>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> pageQueryEntity(Long page, Integer rows, T t);

	/**
	 * 分页查询
	 * <p>
	 * 带参数，自定义排序
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> pageQueryEntity(Long page, Integer rows, T t,
			String sort, String order);

	/**
	 * 无参数
	 * 
	 * 查询统计
	 * 
	 * @return
	 */
	public long pageQueryEntityCount();

	/**
	 * 对象查询
	 * 
	 * 查询统计
	 * 
	 * @return
	 */
	public long pageQueryEntityCount(T t);
}
