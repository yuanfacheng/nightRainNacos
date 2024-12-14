package com.admin.rain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: yfc
 * @Date: 2024/11/14 19:46
 */
public class DiscoveryController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/discovery")
	public List<String> discoveryHandle(){
		List<String> services = client.getServices();
		for(String serviceName: services){
			List<ServiceInstance> instances = client.getInstances(serviceName);
			for(ServiceInstance instance : instances){
				Map<String,Object> map = new HashMap<>();
				map.put("serviceName",serviceName);
				map.put("instanceId",instance.getInstanceId());
				map.put("host",instance.getHost());
				map.put("scheme",instance.getScheme());
				map.put("port",instance.getPort());
				map.put("uri",instance.getUri());
				System.out.println(map);
			}
		}
		return services;
	}
}
