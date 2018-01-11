package com.wanghao.factory;/**
 * Created by Administrator on 2018/1/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工厂类
 *有点模拟spring中的beanFactory的意思, 就是让这些东西存放在一个map里面.
 * @author WangH
 * @create 2018-01-11 11:36
 **/
public class FactoryMain {

    private static Logger logger= LoggerFactory.getLogger(FactoryMain.class);
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContent classPathXmlApplicationContent=new ClassPathXmlApplicationContent("com.wanghao.factory.UserInfo");
        UserInfo userInfo= (UserInfo) classPathXmlApplicationContent.getBean("userInfo");
        userInfo.setId(1);
        userInfo.setName("name");
        logger.info(userInfo.toString());
        
    }
    
}
