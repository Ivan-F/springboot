package cn.just_do.springboot.bll;

import cn.just_do.springboot.common.util.Util;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class UserService {

//    static {
//        try {
//            String path1 = "D:\\Program\\GitHub\\springboot\\src\\main\\resources\\jni";
//            String path2 = "D:\\Workspace\\GitHub\\springboot\\src\\main\\resources\\jni";
//            Util.addLibraryDir(path1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.loadLibrary("auth");
//    }
    @Async
    public void login(){
        String[] a = {"11201120GNC","#$#@"};
//        auth2("11201120");
        auth4();
        System.out.println("Native Function Execution Complete");
    }

    private native void auth();

    private native void auth2(String a);
    private native void auth3(String[] a);

    private void  auth4(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{

        Process p = Runtime.getRuntime().exec("cmd /C start ping www.baidu.com");
        br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
