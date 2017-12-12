package cn.just_do.springboot.domain;

import java.util.List;

public class TT<T> {
    private List<T> ttt;


    public List<T> getTtt() {
        return ttt;
    }

    public void setTtt(List<T> ttt) {
        this.ttt = ttt;
    }
}
