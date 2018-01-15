package com.wanghao.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanghao on 2018/1/14.
 */
public class TestMain {

    public static void main(String[] args) {
        String str1="卢姿 女 15073828680 15073828680 卢丽华 17610059390 2017-08-06 19:52:55 身份证 432503199901094040 高起本双证 2568357424@qq.com 本科 自考保过 吉林艺术学院 艺术设计 26000 23900 分期付款 1.5年 否 ";
       // str1="李和信 男 13581889605   2017-08-06 21:09:28 身份证 130927198805133316 乐惠码7382 331928530@qq.com 本科 自考保过 对外经济贸易大学 采购与供应管理 10500 10500 在线支付 2年 否 ";
       // str1="田红莲 女 13511059123  13511057665 2017-08-01 09:58:54 身份证 130626198204085344  737508776@qq.com 专科 自考保过 北京财贸职业学院 连锁经营管理 7000 7000 POS 1年 否 ";
        str1="卢姿 女 15073828680  卢丽华 17610059390 2017-08-06 19:52:55 身份证 432503199901094040 高起本双证 2568357424@qq.com 本科 自考保过 吉林艺术学院 艺术设计 26000 23900 分期付款 1.5年 否 ";
      //  System.out.println(getStudetInfo(str1));   
        String [] a =str1.split(" ");
        int i=0;
        for(String s:a){
           System.out.println("start"+s+"end"+"---->"+i);
            i++;
        }
        
    
    }

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(19[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    
    
}
