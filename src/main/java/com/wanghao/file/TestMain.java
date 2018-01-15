package com.wanghao.file;

/**
 * Created by wanghao on 2018/1/14.
 */
public class TestMain {

    public static void main(String[] args) {
        String str1="张春春 2017-10-12 21:12:23 似的";
        String abc=str1.substring(str1.indexOf("201"),str1.indexOf("201")+11);
        String d=str1.substring(str1.indexOf("201"),str1.indexOf("201")+10);
        System.out.println(abc);
        String f=str1.replaceAll(abc,d);
        System.out.println(f);
        System.out.println(str1.indexOf("201")+10);
    }

}
