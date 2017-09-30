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
        System.loadLibrary("auth");
    }
    @Async
    public void login(){
        String[] a = {"11201120GNC","#$#@"};
        auth3(a);
        System.out.println("Native Function Execution Complete");
    }

    private native void auth();

    private native void auth2(String a);
    private native void auth3(String[] a);
}
