package com.wanghao.chain;/**
 * Created by Administrator on 2018/2/28.
 */

import java.util.List;

/**
 * @author WangH
 * @create 2018-02-28 15:39
 **/
public class Chain {
    
    private int index;
    
    private List<ChainHandler> handers;

    public Chain(List<ChainHandler> handers) {
        this.handers = handers;
    }
    
    public void process(){
        if(index>=handers.size()){
            return;
        }
        handers.get(index++).executor(this);
    }
    
}
