package cn.just_do.springboot;

import cn.just_do.springboot.common.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.*;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
//		try {
//			Util.addLibraryDir("/home/ivan/Downloads/testconvert/");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.loadLibrary("convert");
//		SpringApplication.run(Application.class, args);

		int a = 01;
		int ref = 12;
		if((ref & a) == 1){
			System.out.println("true:" + (ref & a));
		}else{
			System.out.println("false:" + (ref & a));
		}

	}

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
}
