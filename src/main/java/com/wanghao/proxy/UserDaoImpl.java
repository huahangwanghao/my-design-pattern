package com.wanghao.proxy;/**
 * Created by Administrator on 2018/1/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangH
 * @create 2018-01-11 10:35
 **/
public class UserDaoImpl implements UserDao {
    private static Logger logger= LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public void save() {
        logger.info("save data success!");
    }
    
    public static void test(){
        logger.info("test data success!");
    }
}
