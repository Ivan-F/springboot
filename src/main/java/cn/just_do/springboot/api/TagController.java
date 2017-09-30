package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;

import cn.just_do.springboot.domain.TagLibrary;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
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
	public void delTag(@RequestParam("file") MultipartFile file){
		System.out.println("test3-/{id}-----:" + file);
	}

	@RequestMapping("/upload")
	public void upload(MultipartFile[] file){
		System.out.println(file[0].getName());
		System.out.println(file[0].getOriginalFilename());
	}
}
