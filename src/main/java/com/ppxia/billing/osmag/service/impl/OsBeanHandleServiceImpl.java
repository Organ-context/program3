package com.ppxia.billing.osmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.osmag.dao.impl.IOsBeanHandleDao;
import com.ppxia.billing.osmag.service.IOsBeanHandleService;

@Service
public class OsBeanHandleServiceImpl implements IOsBeanHandleService {
	
	@Resource
	private IOsBeanHandleDao osBeanHandleDaoImpl;
	@Override
	public void saveOsBean(OsBean bean) {
		osBeanHandleDaoImpl.save(bean);
	}

	@Override
	public void updateOsBean(OsBean bean) {
		osBeanHandleDaoImpl.saveAndFlush(bean);
	}

	@Override
	public void deleteOsBean(Long id) {
		osBeanHandleDaoImpl.delete(id);
	}

}
