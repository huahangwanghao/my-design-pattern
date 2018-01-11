package com.wanghao.factory;/**
 * Created by Administrator on 2018/1/11.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangH
 * @create 2018-01-11 14:13
 **/
public class ClassPathXmlApplicationContent implements BeanFactory {
    
    private static Map<String,Object> map=new HashMap<String,Object>(); 
    
    private String className;

    public ClassPathXmlApplicationContent(String className) {
        this.className = className;
    }

    @Override
    public Object getBean(String name) {

        Object bean = map.get(name);

        if (bean == null) {
            doCreateBean(name);
            bean=map.get(name);
        }
        return bean;
    }  
      
    
    public void doCreateBean(String name){
        try {
            map.put(name,Class.forName(className).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
