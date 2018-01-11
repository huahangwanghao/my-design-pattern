package com.wanghao.proxy;/**
 * Created by Administrator on 2018/1/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *
 * @author WangH
 * @create 2018-01-11 10:43
 **/
public class JDKProxy {
    private static Logger logger= LoggerFactory.getLogger(StaticUserDaoProxy.class);
    //目标对象
    private UserDao target;

    public JDKProxy(UserDao userDao) {
        this.target = userDao;
    }
    
    public Object getProxyInstance(){
        
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //这里面是实现的具体逻辑
                logger.info("调用jdk代理之前的方法");
                Object returnValue=method.invoke(target,args);
                logger.info("调用jdk代理之后的方法");
                return returnValue;
            }
        });
        
    }
    
    
}
