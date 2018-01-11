package com.wanghao.singleton;/**
 * Created by Administrator on 2018/1/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangH
 * @create 2018-01-11 14:28
 **/
public class SingletonMain {

    private static Logger logger= LoggerFactory.getLogger(SingletonMain.class);
    
    public static void main(String[] args) {
        //test();
        //test1();
        test2();
    }

    /***
     * 同时让10个线程访问这个单例对象,
     * 因为里面有一个判断,如果是空就创建对象. 开始有俩个线程同时判断到了是空, 所以创建来个对象啦
     */
    public static void test(){

        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    Singleton singleton1=Singleton.getSingleton1();
                    logger.info(singleton1.toString());

                }
            }.start();
        }

    }

    /**
     * 利用static的属性,在类加载的时候就创建了对象. 这个只有一份....
     * 但是, 这个问题在于无论是否用得到.都会创建这个对象
     */
    public static void test1(){
        
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    Singleton1 singleton1=Singleton1.getSingleton1();
                    logger.info(singleton1.toString());

                }
            }.start();
        }
        
    }

    /**
     * 利用static 内部类的机制. 先创建一个内部类, 调用getSingleton()的时候才调用内部类, 否则不调用. 也就不初始化啦.
     * 因为内部类 没有被调用就不会初始化....
     */
    public static void test2(){

        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    Singleton2 singleton1=Singleton2.getSingleton();
                    logger.info(singleton1.toString());

                }
            }.start();
        }

    }
    
}
