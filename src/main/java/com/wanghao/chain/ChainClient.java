package com.wanghao.chain;/**
 * Created by Administrator on 2018/2/28.
 */

import java.util.Arrays;
import java.util.List;

/**
 * 责任链客户端
 *
 * @author WangH
 * @create 2018-02-28 15:39
 **/
public class ChainClient {

    static class ChainHandlerA extends ChainHandler{

        @Override
        protected void selfProcess() {
            System.out.println("this is for A");
        }
    }
    static class ChainHandlerB extends ChainHandler{

        @Override
        protected void selfProcess() {
            System.out.println("this is for B");
        }
    }
    static class ChainHandlerC extends ChainHandler{

        @Override
        protected void selfProcess() {
            System.out.println("this is for C");
        }
    }
    
    public static void main(String[] args) {

        List<ChainHandler> lists= Arrays.asList(new ChainHandlerA(),new ChainHandlerB(),new ChainHandlerC());
        
        Chain chain=new Chain(lists);
        
        chain.process();
        
    }
    
}
