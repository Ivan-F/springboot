package cn.just_do.springboot.bll;

import cn.just_do.springboot.common.util.Util;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

@Service
public class UserService {

    static {
        try {
            Util.addLibraryDir("D:\\Workspace\\GitHub\\springboot\\src\\main\\resources\\jni");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.loadLibrary("hello");
    }
    @Async
    public void login(){

        auth();
        System.out.println("Native Function Execution Complete");
    }

    private native void auth();
}
