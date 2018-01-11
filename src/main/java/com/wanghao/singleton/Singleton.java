package com.wanghao.singleton;/**
 * Created by Administrator on 2018/1/11.
 */

/**
 * @author WangH
 * @create 2018-01-11 14:27
 **/
public class Singleton {
    
    private static Singleton singleton1;
    
    private Singleton(){}
    
    public static Singleton getSingleton1(){
        if(singleton1==null){
            singleton1=new Singleton();
        }
        return singleton1;
    }
    
}
