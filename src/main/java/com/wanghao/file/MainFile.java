package com.wanghao.file;

import java.io.*;
import java.util.Scanner;

/**
 * Created by wanghao on 2018/1/14.
 */
public class MainFile {
    public static void main(String[] args) throws Exception {
        try {
            Scanner in = new Scanner(new File("d:/1.txt"));
            String str="";
            while (in.hasNextLine()) {
                 str = in.nextLine();
                str=str.substring(str.indexOf("客户姓名"),str.indexOf("合计项目"));
               // System.out.println(str);
                //splitt(str);
            }
            String fileStr=str;
            fileStr=fileStr.replaceAll("是否包含学位 ","是否包含学位 \n");
            fileStr=fileStr.replaceAll(" 是 "," 是 \n");
            fileStr=fileStr.replaceAll(" 否 "," 否 \n");
           // System.out.println(fileStr);


            File writename = new File("D://3.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(fileStr); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件


            Scanner in1 = new Scanner(new File("d:/3.txt"));
            String str1="";
            while (in1.hasNextLine()) {
                str1 = in1.nextLine();
                System.out.println(str1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }









    public static String[] splitt(String str){
        String strr = str.trim();
        String[] abc = strr.split("[\\p{Space}]+");
        String str1 = abc[0];
        String str2 = abc[1];
        System.out.println(str1);
        System.out.println(str2);
        return abc;
    }



}
