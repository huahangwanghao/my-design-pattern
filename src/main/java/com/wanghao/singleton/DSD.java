package com.wanghao.singleton;/**
 * Created by Administrator on 2018/2/1.
 */

/**
 * @author WangH
 * @create 2018-02-01 10:40
 **/
public class DSD {
    
    
    private static final DSD dsd=new DSD();
    //假如有这个变量....这时候调用key的时候, 也把dsd给创建出来啦.
    public static final  String key="abc";
    
    private DSD(){}
    
    public static DSD getInstance(){
        return dsd;
    }
    
}
