package com.llhao.spring.bean;

import com.llhao.spring.Test;
import com.llhao.spring.support.MyBeanReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by llhao on 2017/3/23.
 */
public class MyApplicationContext{
    private Map<String,Object> beans = new HashMap<String,Object>();
    public MyApplicationContext(InputStream is) {
        MyBeanReader reader = new MyBeanReader();
        try {
            List<MyBean> myBeans = reader.read(Test.class.getResourceAsStream("/applicationContext.xml"));
            for (MyBean bean : myBeans) {
                beans.put(bean.getName(),bean.getClazz().newInstance());
            }
            for (MyBean bean : myBeans) {
                Class beanCls = bean.getClazz();
                Object beanObj = beans.get(bean.getName());
                Map<String,String> props = bean.getProperties();
                Set<String> keys = props.keySet();
                for (String key : keys) {
                    Field field = beanCls.getDeclaredField(key);
                    field.setAccessible(true);
                    field.set(beanObj,beans.get(props.get(key)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBeans(String name) {
        return beans.get(name);
    }
}
