package com.admin.rain.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: yfc
 * @Date: 2024/11/9 19:43
 */
//@FeignClient("${rain.consumer}")
@FeignClient("service-consumer")
public interface ConsumerClient {
	@RequestMapping("/consumer/show")
	public String showConsumer();
}
