package com.admin.rain.service;

import com.admin.rain.model.po.OmsOrder;
import com.admin.rain.model.vo.OmsOrderVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * C端产品业务接口
 *
 * @author yfc
 * @since 2024-6-12 16:30:00
 */
public interface OmsOrderService extends IService<OmsOrder> {


	/**
	 * 查询产品列表
	 * @Param finProductBusinessPageRequest
	 * @Return
	 * @Author yfc
	 * @Date 2024-6-12 16:30:00
	 */
//	List<OmsOrderVo> list(FinProductBusinessPageRequest finProductBusinessPageRequest);

	/**
	 * 根据id查询C端产品业务详情
	 * @Param id
	 * @Return
	 * @Author yfc
	 * @Date 2024-6-12 16:30:00
	 */
	OmsOrderVo query(String id);

}
