package com.wanghao.singleton;/**
 * Created by Administrator on 2018/1/11.
 */

/**
 * @author WangH
 * @create 2018-01-11 14:27
 **/
public class Singleton1 {
    
    private static Singleton1 singleton1=new Singleton1();
    
    private Singleton1(){}
    
    public static Singleton1 getSingleton1(){
        return singleton1;
    }
    
}
