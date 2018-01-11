package com.wanghao.proxy;/**
 * Created by Administrator on 2018/1/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 代理模式主方法
 * 分为三种模式
 * 1.静态代理
 * 2.动态代理
 * 3.cglib代理
 *
 * @author WangH
 * @create 2018-01-11 10:32
 **/
public class ProxyMain {

    private static Logger logger= LoggerFactory.getLogger(ProxyMain.class);
    
    public static void main(String[] args) {

        //testStaticProxy();
       // testJDKProxy();
        testCglib();
    }

    /**
     * 静态代理
     * 优点:可以做到在不修改<b>UserDaoImpl</b>的代码基础上,对于功能进行扩展
     * 缺点:因为需要和目标对象实现同一个接口,所有会出现很多代理类,一旦接口变化,需要维护的成本很大
     */
    public static void testStaticProxy(){
        StaticUserDaoProxy staticUserDaoProxy=new StaticUserDaoProxy(new UserDaoImpl());
        staticUserDaoProxy.save();
    }

    /**
     * jdk动态代理
     * 代理对象不许实现接口. 但是 目标对象必须实现接口....
     */
    public static void testJDKProxy(){
        UserDao userDao=new UserDaoImpl();
        UserDao userDaoProxy= (UserDao) new JDKProxy(userDao).getProxyInstance();
        userDaoProxy.save();
    }

    /**
     * 对于静态代理和jdk代理,都是需要目标对象实现一个接口. 假如需要代理的对象就是没有实现接口.这时候怎么办呢????
     * 这时候可以以<b>目标对象的子类</b>的方式 进行代理.
     * <br/>
     * Cglib代理: 子类代理, 需要在内存中构建一个目标对象的子类对象.<br>
     * <ol>
     *     <li>目标类不能使用final修改, 这样就没有子类啦</li>
     *     <li>目标对象的方法如果是 static/final 修改 就不能被代理啦.</li>
     *     <li>123</li>
     *     <li>123</li>
     *     
     * </ol>   
     *
     */
    public static void testCglib(){
        UserDao userDao=new UserDaoImpl();
        CglibProxy cglibProxy=new CglibProxy(userDao);
        UserDao userDaoProxy= (UserDao) cglibProxy.getProxyInstance();
        userDaoProxy.save();
    }

}
