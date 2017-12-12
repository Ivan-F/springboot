package cn.just_do.springboot.api;

import javax.servlet.http.HttpServletRequest;

import cn.just_do.springboot.bll.TestService;
import cn.just_do.springboot.task.FileConvertTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


	@Autowired
	private FileConvertTask ft;

	@Autowired
	private TestService ts;

	@RequestMapping(value="",method=RequestMethod.GET)
	public String test1(HttpServletRequest req){
		List<String> list =  Arrays.asList("110","111","112");
		ft.setListFilePath(list);
		AsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		System.out.println("task start...");
		asyncTaskExecutor.execute(ft);
		System.out.println("task end...");
		return "SUCCESS";
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public void test2(HttpServletRequest req){
		List<String> list =  Arrays.asList("110","111","112");
		this.ts.fileConvert(list);
	}
}
