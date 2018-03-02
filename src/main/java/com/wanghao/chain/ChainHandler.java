package com.wanghao.chain;/**
 * Created by Administrator on 2018/2/28.
 */

/**
 * @author WangH
 * @create 2018-02-28 15:39
 **/
public abstract class ChainHandler {
    
    
    protected abstract  void selfProcess();
    
    public void executor(Chain chain){
        //先处理自己类的方法
        selfProcess();
        //
        chain.process();
    }
    
    
}
