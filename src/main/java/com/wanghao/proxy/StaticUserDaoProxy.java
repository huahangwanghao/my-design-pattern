package com.wanghao.proxy;/**
 * Created by Administrator on 2018/1/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理
 * @author WangH
 * @create 2018-01-11 10:36
 **/
public class StaticUserDaoProxy implements UserDao {
    private static Logger logger= LoggerFactory.getLogger(StaticUserDaoProxy.class);
    private UserDao userDao;

    public StaticUserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        logger.info("静态代理方法执行前的代码");
        userDao.save();
        logger.info("静态代理方法执行后的代码");
    }
}
