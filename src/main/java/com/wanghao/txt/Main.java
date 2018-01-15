package com.wanghao.txt;/**
 * Created by Administrator on 2018/1/13.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * 读取txt文件
 *
 * @author WangH
 * @create 2018-01-13 17:25
 **/
public class Main {

   public  static void main(String args[]) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  

                /* 读入TXT文件 */
            String pathname = "D:\\1.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";
            line = br.readLine();
           
           /* while (line != null) {
                line = br.readLine(); // 一次读入一行数据  
               *//* int index=line.indexOf("客户姓名");
                System.out.println(index);*//*
            }*/
            int index=line.indexOf("客户姓名");
            String newLine=line.substring(index,line.indexOf("合计项目"));
            newLine=newLine.replaceAll("是否包含学位 ","是否包含学位 \n");
            newLine=newLine.replaceAll(" 否 "," 否 \n");
            newLine=newLine.replaceAll(" 是 "," 是 \n");
            
           // System.out.println(newLine);

                /* 写入Txt文件 */
            File writename = new File("D:\\2.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件  
            writename.createNewFile(); // 创建新文件  
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(newLine); // \r\n即为换行  
            out.flush(); // 把缓存区内容压入文件  
            out.close(); // 最后记得关闭文件  

            String pathname2 = "D:\\2.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename2 = new File(pathname2); // 要读取以上路径的input。txt文件  
            InputStreamReader reader2 = new InputStreamReader(
                    new FileInputStream(filename2)); // 建立一个输入流对象reader  
            BufferedReader br2 = new BufferedReader(reader2); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line2 = "";
            line2 = br2.readLine();
            System.out.println(line2);
            while (line2 != null) {
                line2 = br.readLine();
                
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
