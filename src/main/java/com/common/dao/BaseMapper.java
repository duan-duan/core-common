/**
 * 
 */
package com.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.common.entity.BaseEntity;

/**
 * @author huanggaoren
 * 
 */
public interface BaseMapper<T extends BaseEntity, ID extends Serializable> {

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
	public int deleteByIds(Map<String, Object> params);

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
	 * 查询所有的出列表
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
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<T> pageQueryEntity(T t);

	/**
	 * 查询统计
	 * 
	 * @return
	 */
	public long pageQueryEntityCount(T t);
}
