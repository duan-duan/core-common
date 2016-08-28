/**   
 * @Title: HighArray.java 
 * @Package com.gome.common.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author huanggaoren
 * @E-mail itorac@sina.com.cn   
 * @date 2015年1月9日 上午11:14:18 
 * @version V1.0.0 
 */
package com.common.util;

/**
 * @ClassName: HighArray
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huanggaoren
 * @E-mail itorac@sina.com.cn
 * @date 2015年1月9日 上午11:14:18
 * 
 */
public class HighArray {

	private long[] array;

	private int element;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public HighArray(int max) {
		array = new long[max];
		element = 0;
	}

	/**
	 * 
	 * @Title: addItem
	 * @Description: TODO 增加元素
	 * @param @param value 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void insert(long value) {
		array[element] = value;
		element++;
	}

	/**
	 *
	 * @Title: display
	 * @Description: TODO 显示全部
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void display() {
		for (int i = 0; i < element; i++)
			System.out.print(array[i] + "\n");
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO 删除
	 * @param @param value
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean delete(long value) {
		int j;
		for (j = 0; j < element; j++)
			if (value == array[j])
				break;
		if (j == element)
			return false;
		else {
			for (int k = j; k < element; k++)
				array[k] = array[k + 1];
			element--;
			return true;
		}
	}

	/**
	 * 
	 * @Title: find
	 * @Description: TODO 数组查询
	 * @param @param searchKey
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < element; j++)
			if (array[j] == searchKey)
				break;
		if (j == element)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		HighArray ha = new HighArray(10);
		ha.insert(10);
		ha.insert(20);
		ha.insert(30);
		ha.insert(5);
		ha.display();
		if (ha.delete(10)) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		ha.display();
		long searchkey = 20;
		if (ha.find(searchkey)) {
			System.out.println("查找数据成功：" + searchkey);
		} else {
			System.out.println("没有要找到的数据");
		}
	}
}
