/**
 * @Title:InStorageService.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.service;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.pojo.Pagination;

/**
 * @Title:InStorageService
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public interface InStorageService {
	/**
	 * @param page
	 * @param rows
	 * @return
	 */
	Pagination<InStorage> selInStorageByPage(int page, int rows);
}
