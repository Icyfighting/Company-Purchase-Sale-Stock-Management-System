/**
 * @Title:AddInStorageServiceImpl.java 
 * @Description:TODO
 * @Copyright:Copyright(c) 2018. All rights reserved.
 * @Company:bjsxt 304
 *
 * @author Wang Jie
 * @date 2018年3月15日
 * @version 1.0
 */
package com.bjsxt.wangjie.service.impl;

import com.bjsxt.pojo.InStorage;
import com.bjsxt.wangjie.dao.AddInStorageDao;
import com.bjsxt.wangjie.dao.impl.AddInStorageDaoImpl;
import com.bjsxt.wangjie.service.AddInStorageService;

/**
 * @Title:AddInStorageServiceImpl
 * @Description:TODO
 * @Company:bjsxt 304
 * 
 * @author Wang Jie
 * @data 2018年3月15日
 */
public class AddInStorageServiceImpl implements AddInStorageService {
	private AddInStorageDao addInStorageDao = new AddInStorageDaoImpl();
	@Override
	public boolean addInStorage(InStorage inStorage) {
		// TODO Auto-generated method stub
		return addInStorageDao.addInStorage(inStorage);
	}

}
