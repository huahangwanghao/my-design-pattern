package com.wanghao.nio;/**
 * Created by Administrator on 2018/1/16.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 复制的简单例子
 *
 * @author WangH
 * @create 2018-01-16 14:57
 **/
public class CopyFile {

    
    static public  void main(String[] args) throws IOException {
        if (args.length<2) {
            System.err.println( "Usage: java CopyFile infile outfile" );
            System.exit( 1 );
        }

        String infile = args[0];
        String outfile = args[1];

        FileInputStream fin = new FileInputStream( infile );
        FileOutputStream fout = new FileOutputStream( outfile );

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate( 1024 );

        while (true) {
            buffer.clear();

            int r = fcin.read( buffer );

            if (r==-1) {
                break;
            }

            buffer.flip();

            fcout.write( buffer );
        }
    }
    
    
    
}
