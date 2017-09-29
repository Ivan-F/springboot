package cn.just_do.springboot.bll;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    {
        System.loadLibrary("auth");
    }
    @Async
    public void login(){
        auth();
        System.out.println("Native Function Execution Complete");
    }

    private native void auth();
}
