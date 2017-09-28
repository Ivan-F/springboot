package cn.just_do.springboot.bll;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private native List<String> convert(List<String> list);

    @Async
    public void fileConvert(List<String> list){
        List<String> failedList = convert(list);
    }
}
