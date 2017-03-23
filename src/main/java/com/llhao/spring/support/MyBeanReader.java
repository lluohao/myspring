package com.llhao.spring.support;

import com.llhao.spring.bean.MyBean;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by llhao on 2017/3/23.
 */
public class MyBeanReader {
    private static SAXParserFactory factory = SAXParserFactory.newInstance();

    public List<MyBean> read(InputStream is) throws IOException {
        List<MyBean> beans = new ArrayList<MyBean>();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(is, new BeanHandler(beans));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return beans;
    }

    private static class BeanHandler extends DefaultHandler {
        private List<MyBean> beans;
        private MyBean currentBean;

        public BeanHandler(List<MyBean> beans) {
            this.beans = beans;
        }

        public List<MyBean> getBeans() {
            return beans;
        }


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("bean".equalsIgnoreCase(qName)) {
                parseBean(attributes);
            } else if ("property".equalsIgnoreCase(qName)) {
                parseProperty(attributes);
            }
        }

        private void parseProperty(Attributes attributes) {
            String name = attributes.getValue("name");
            String ref = attributes.getValue("ref");
            String value = attributes.getValue("value");
            if(name==null){
                throw new RuntimeException("属性名不能为空");
            }
            if(ref!=null){
                currentBean.addProperty(name,ref);
            }
        }

        private void parseBean(Attributes attributes) {
            String id = attributes.getValue("id");
            String clazz = attributes.getValue("class");
            if (id == null) {
                throw new RuntimeException("id不能为空");
            } else if (clazz == null) {
                throw new RuntimeException("class不能为空");
            }
            try {
                Class cls = Class.forName(clazz);
                currentBean = new MyBean(id, cls);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("bean".equalsIgnoreCase(qName)) {
                beans.add(currentBean);
                currentBean = null;
            }
        }
    }
}
