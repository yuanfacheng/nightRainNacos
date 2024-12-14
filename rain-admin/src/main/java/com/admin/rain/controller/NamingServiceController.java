package com.admin.rain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: yfc
 * @Date: 2024/11/14 19:46
 */
@RestController
@RequestMapping("/naming")
public class NamingServiceController {

	@Autowired
	private DiscoveryClient client;

	@NacosInjected
	private NamingService namingService;

	@Value("${spring.application.name}")
	private String serviceName;

//	@RequestMapping("/discovery")
//	public List<Instance> namingDiscovery() throws NacosException {
//		List<Instance> allInstances = namingService.getAllInstances(serviceName);
//		for (Instance in : allInstances) {
//			Map<String, Object> map = new HashMap<>();
//			map.put("serviceName", in.getServiceName());
//			map.put("ClusterName", in.getClusterName());
//			map.put("host", in.getInstanceHeartBeatInterval());
//			map.put("instanceId", in.getInstanceId());
//			map.put("ip", in.getIp());
//			map.put("port", in.getPort());
//			map.put("instanceHeartBeatTimeOut", in.getInstanceHeartBeatTimeOut());
//			System.out.println(map);
//		}
//		return allInstances;
//	}
}
