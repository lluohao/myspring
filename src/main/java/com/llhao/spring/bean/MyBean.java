package com.llhao.spring.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by llhao on 2017/3/23.
 */
public class MyBean {
    private Map<String,String> properties= new HashMap<String,String>();
    private String name;
    private Class clazz;

    public MyBean() {

    }

    public MyBean(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void addProperty(String name,String value){
        properties.put(name,value);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
