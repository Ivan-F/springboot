package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;

import cn.just_do.springboot.bll.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping("")
	public void test1(HttpServletRequest req){
		userService.login();
	}
	
}
