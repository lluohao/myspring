package com.llhao.spring;

import com.llhao.spring.bean.MyApplicationContext;
import com.llhao.spring.service.ICityService;

import java.io.IOException;

/**
 * Created by llhao on 2017/3/23.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        MyApplicationContext ctx = new MyApplicationContext(Test.class.getResourceAsStream("/applicationContext.xml"));
        ICityService city = (ICityService) ctx.getBeans("cityService");
        city.addCity("北京",30,110);
    }
}
