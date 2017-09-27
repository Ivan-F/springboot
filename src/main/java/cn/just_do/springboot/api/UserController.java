package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;

@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * 新增
	 * @param req
	 */
	@PutMapping("")
	public void test1(HttpServletRequest req){
		System.out.println("test1------");
		System.out.println("URI--:" + req.getRequestURI());
		System.out.println("URL--:" + req.getRequestURL());
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public void test2(HttpServletRequest req){
		System.out.println("test2------:");
		System.out.println("URI--:" + req.getRequestURI());
		System.out.println("URL--:" + req.getRequestURL());
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public void test3(@PathVariable("id")String id,HttpServletRequest req,String a){
		System.out.println("test3-/{id}-----:" + id);
		System.out.println("URI--:" + req.getRequestURI());
		System.out.println("URL--:" + req.getRequestURL());
	}
	
}
