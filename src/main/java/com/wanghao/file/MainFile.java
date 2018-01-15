package com.wanghao.file;

import java.io.*;
import java.util.Scanner;

/**
 * Created by wanghao on 2018/1/14.
 */
public class MainFile {
    public static void main(String[] args) throws Exception {
        try {
            StringBuffer sb=new StringBuffer();
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
                if(str1.contains("关联手机号")){
                    sb.append(str1+"\n");
                    continue;
                }
                String abc=str1.substring(str1.indexOf("201"),str1.indexOf("201")+11);
                String d=str1.substring(str1.indexOf("201"),str1.indexOf("201")+10);
                str1=str1.replaceAll(abc,d);
                str1=dealString(str1);
                //System.out.println(str1);
                sb.append(str1+"\n");
            }
            System.out.println(sb.toString());
            write2File(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write2File(String fileStr) throws Exception {
        File writename = new File("D://3.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write(fileStr); // \r\n即为换行
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件

    }


    /**
     * 处理String字符串
     * @param str1
     * @return
     */
    private static String dealString(String str1) {

        //判断有三个空格  一般为 关联手机号  紧急联系人没有
        String [] three=str1.split("   ");
        if(three.length>1){
            String two=three[1];
            boolean a=two.startsWith("201");
            if(a){
                //说明没有基金联系人和 关联手机号
                str1= str1.replaceAll("   "," 关联手机号无 紧急联系人无 ");
            }

            return str1;
        }
        //包含俩个空格的
        String [] twoString=str1.split("  ");
        if(twoString.length>1){
            String two=twoString[1];
            if(two.startsWith("1")){
                //表明是有 关联手机号
                str1= str1.replaceAll(" 201"," 紧急联系人无 201");
            }else{
                //表明是有紧急联系人
                str1= str1.replaceAll("  "," 关联手机号无 ");
            }
            return str1;
        }

        return str1;

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
