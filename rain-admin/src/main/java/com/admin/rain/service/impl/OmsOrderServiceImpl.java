package com.admin.rain.service.impl;


import com.admin.rain.dao.OmsOrderDao;
import com.admin.rain.model.po.OmsOrder;
import com.admin.rain.model.vo.OmsOrderVo;
import com.admin.rain.service.OmsOrderService;
import com.admin.rain.service.base.OmsOrderBaseService;
import com.admin.rain.service.service.RedisService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Description: C端产品业务实现类
 * @Author:yuan
 * @Date: 2024/6/12  16:31
 *
 **/
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrder> implements OmsOrderService {

	@Autowired
	private OmsOrderBaseService omsOrderBaseService;

	@Autowired
	private RedisService redisService;
	/**
	 * 根据id查询C端产品业务详情
	 *
	 * @Param id
	 * @Return
	 * @Author yfc
	 * @Date 2024-6-12 16:30:00
	 */
	@Override
	public OmsOrderVo query(String id) {

		OmsOrderVo orderVo = null;
		try {
			LambdaQueryWrapper<OmsOrder> wrapper = new LambdaQueryWrapper<>();
			wrapper.eq(OmsOrder::getId, id);

			OmsOrder order = omsOrderBaseService.selectOne(wrapper);
			orderVo = new OmsOrderVo();
			BeanUtils.copyProperties(order,orderVo);
			redisService.set("ddd",123);
			Integer aaa =(Integer) redisService.get("ddd");
			System.out.println(aaa);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return orderVo;
	}

}
