package com.wanghao.txt;/**
 * Created by Administrator on 2018/1/13.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读取txt文件
 *
 * @author WangH
 * @create 2018-01-13 17:25
 **/
public class Main2 {
    public static void main(String args[]) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  

                /* 读入TXT文件 */
            String pathname = "D:\\2.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";
            line = br.readLine();
            System.out.println(line);
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据  
                System.out.println(line);
            }  


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
