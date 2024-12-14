package com.admin.rain.service.base.impl;

import javax.annotation.Resource;

import com.admin.rain.dao.OmsOrderDao;
import com.admin.rain.service.base.OmsOrderBaseService;

import org.springframework.stereotype.Service;


@Service
public class OmsOrderBaseServiceImpl implements OmsOrderBaseService {
	@Resource
	private OmsOrderDao omsOrderDao;

	@Override
	public OmsOrderDao getDao() {
		return omsOrderDao;
	}
}
