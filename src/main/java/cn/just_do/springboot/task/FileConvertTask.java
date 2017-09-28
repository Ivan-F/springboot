package cn.just_do.springboot.task;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Scope("prototype")
public class FileConvertTask implements Runnable {

    private List<String> listFilePath;

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            listFilePath.forEach(it -> System.out.println("it = " + it));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> getListFilePath() {
        return listFilePath;
    }

    public void setListFilePath(List<String> listFilePath) {
        this.listFilePath = listFilePath;
    }

}
