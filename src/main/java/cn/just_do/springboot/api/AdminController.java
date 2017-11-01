package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AdminController {



	@RequestMapping("/convert")
	public String test1(HttpServletRequest req){
		new NativeFunc().nativeConvertOne("/home/ivan/Downloads/testconvert/CN5GW0WQ.000");
		return "SUCCESS";
	}

}
