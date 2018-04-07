package com.dlika.aws.AwsCDeploymentTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/")
	public String testApi() {
		return "It works :P";
	}

}