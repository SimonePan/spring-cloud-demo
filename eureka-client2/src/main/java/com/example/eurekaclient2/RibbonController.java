package com.example.eurekaclient2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Grace.Pan
 * @date 2018/9/6
 */
@RestController
public class RibbonController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/loadInstance")
	public String loadInstance() {
		ServiceInstance choose = loadBalancerClient.choose("eureka-client");
		String info = choose.getServiceId() + ":" + choose.getHost() + ":" + choose.getPort();
		System.out.println("===info=" + info);
		return info;

	}
}
