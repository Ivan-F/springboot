package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;

import cn.just_do.springboot.bll.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private UserService userService;

	/**
	 * 新增
	 * @param req
	 */
	@PutMapping("")
	public void test1(HttpServletRequest req){
		userService.login();
	}

	
}
