package com.admin.rain.controller;

import com.admin.rain.model.vo.OmsOrderVo;
import com.admin.rain.service.OmsOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/omsorder")
@RefreshScope
public class OmsOrderController {

	@Autowired
	private OmsOrderService omsOrderService;

	@RequestMapping("/query")
	public void omsOrderQuery() {
		OmsOrderVo order = omsOrderService.query("12");
		System.out.println(order);
	}

}