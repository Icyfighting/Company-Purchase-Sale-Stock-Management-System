/**
 * @Title:InStorageServiceImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月14日
 * @version 1.0
 */
package com.bjsxt.wangjie.service.impl;

import java.util.List;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.wangjie.dao.InStorageDao;
import com.bjsxt.wangjie.dao.impl.InStorageDaoImpl;
import com.bjsxt.wangjie.service.InStorageService;

/**
 * @Title:InStorageServiceImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月14日
 */
public class InStorageServiceImpl implements InStorageService {
	private InStorageDao inStorageDao = new InStorageDaoImpl();

	@Override
	public Pagination<InStorage> selInStorageByPage(int page, int rows) {
		// TODO Auto-generated method stub
		Pagination<InStorage> p = new Pagination<>();
		List<InStorage> list = inStorageDao.selInStorageByPage((page - 1)
				* rows, rows);
		int total = inStorageDao.selInStorageCount();
		p.setRows(list);
		p.setTotal(total);
		return p;
	}

}
