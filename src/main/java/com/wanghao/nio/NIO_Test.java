package com.wanghao.nio;/**
 * Created by Administrator on 2018/1/16.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO的一些内容
 *
 * @author WangH
 * @create 2018-01-16 14:45
 **/
public class NIO_Test {

    public static void main(String[] args) throws Exception {
        writeTest();
    }


    /**
     * 我们不需要告诉通道要读取多少数据到缓冲区.
     * @throws IOException
     */
    public static void readTest() throws IOException {
        //1.头俩步是获取通道
        FileInputStream fin=new FileInputStream("readMe.txt");
        FileChannel fc=fin.getChannel();
        //2.创建缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //3.将数据从通道读取到缓冲区
        fc.read(buffer);   
    }
    
    
    public static void writeTest()throws  Exception{

        FileOutputStream fout=new FileOutputStream("./readMe1.txt");
        FileChannel fc=fout.getChannel();
        
        ByteBuffer buffer=ByteBuffer.allocate(2014);
        
        byte [] message="hello nio".getBytes();
        
        for(int i=0;i<message.length;i++){
            buffer.put(message[i]);
        }
        
        
        fc.write(buffer);
        
        
    }
}
