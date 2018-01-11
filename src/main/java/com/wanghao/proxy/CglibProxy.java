package com.wanghao.proxy;/**
 * Created by Administrator on 2018/1/11.
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * CGlib动态代理
 *
 * @author WangH
 * @create 2018-01-11 10:43
 **/
public class CglibProxy implements MethodInterceptor{
    
    private static Logger logger= LoggerFactory.getLogger(CglibProxy.class);

    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }
    
    public Object getProxyInstance(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        logger.info("cglib 代理调用之前");
        Object returnValue=method.invoke(target,objects);
        logger.info("cglib 代理调用之后");
        return returnValue;
    }
}
