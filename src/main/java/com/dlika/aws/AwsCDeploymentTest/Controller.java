package com.dlika.aws.AwsCDeploymentTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/")
	public String testApi() throws UnknownHostException {
		return "It works :p  IP=> " + InetAddress.getLocalHost().getHostAddress();
	}

}