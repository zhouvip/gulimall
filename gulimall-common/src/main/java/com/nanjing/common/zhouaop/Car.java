package com.nanjing.common.zhouaop;

import org.springframework.stereotype.Component;

@Component
public class Car {
    @PringLog
    public void show(){
        for (int i = 0; i < 1000000; i++) {

        }
    }
}
