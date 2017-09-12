package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;

import cn.just_do.springboot.domain.TagLibrary;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@ResponseBody
@RequestMapping("/tag")
public class TagController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public TagLibrary test1(HttpServletRequest req){
		TagLibrary tag = new TagLibrary();
		tag.setCreateDate(new Date());
		return tag;
	}
	@GetMapping("/")
	public void test2(HttpServletRequest req){
		System.out.println("test2------:");
		System.out.println("URI--:" + req.getRequestURI());
		System.out.println("URL--:" + req.getRequestURL());
	}
	
	@GetMapping("/{id}")
	public void test3(@PathVariable("id")String id,HttpServletRequest req){
		System.out.println("test3-/{id}-----:" + id);
		System.out.println("URI--:" + req.getRequestURI());
		System.out.println("URL--:" + req.getRequestURL());
	}
	
	@DeleteMapping("/{id}")
	public void delTag(@PathVariable("id")String id,HttpServletRequest req){
		System.out.println("test3-/{id}-----:" + id);
		System.out.println("URI--:" + req.getRequestURI());
		System.out.println("URL--:" + req.getRequestURL());
	}

	@RequestMapping("/upload")
	public void upload(MultipartFile[] file){
		System.out.println(file[0].getName());
		System.out.println(file[0].getOriginalFilename());
	}
}
