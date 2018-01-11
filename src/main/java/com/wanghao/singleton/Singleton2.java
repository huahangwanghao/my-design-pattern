package com.wanghao.singleton;/**
 * Created by Administrator on 2018/1/11.
 */

/**
 * @author WangH
 * @create 2018-01-11 14:27
 **/
public class Singleton2 {
    
    private static Singleton2 singleton1;
    
    private static class SingletonHold{
        private static final Singleton2 singleton2=new Singleton2();
    }
    
    
    private Singleton2(){}
    
    public static Singleton2 getSingleton(){
        
        return SingletonHold.singleton2;
    }
    
}
