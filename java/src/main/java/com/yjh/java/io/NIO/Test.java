package com.yjh.java.io.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {

    public static void main(String[] args) throws IOException {
        long start1 = System.currentTimeMillis();
        IOUtils.ioCopy("C:\\Users\\yjh\\Downloads\\CentOS-7-x86_64-Minimal-1804.iso", "C:\\Users\\yjh\\Downloads\\jdkIO.exe");
        long end1 = System.currentTimeMillis();
        System.out.println("io time = " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        IOUtils.nioCopy("C:\\Users\\yjh\\Downloads\\CentOS-7-x86_64-Minimal-1804.iso", "C:\\Users\\yjh\\Downloads\\jdkNIO.exe");
        long end2 = System.currentTimeMillis();
        System.out.println("io time = " + (end2 - start2));
    }
}

class IOUtils {

    public static void ioCopy(String originFilePath, String newFilePath) throws FileNotFoundException {

        try (FileInputStream fis = new FileInputStream(originFilePath);
             FileOutputStream fos = new FileOutputStream(newFilePath)) {

            byte[] buffer = new byte[1024];
            int length;
            while (-1 != (length = fis.read(buffer))) {
                fos.write(buffer, 0, length);
                fos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nioCopy(String originFilePath, String newFilePath) throws IOException {

        FileInputStream fis = new FileInputStream(originFilePath);
        FileOutputStream fos = new FileOutputStream(newFilePath);

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {

            //判断是否读取完毕
            if (-1 == inChannel.read(buffer)) {
                break;
            }

            //重新设置buffer的position=0， limit = 原来的 position
            buffer.flip();

            //开始写
            outChannel.write(buffer);

            //写完重设buffer
            buffer.clear();
        }

        inChannel.close();
        outChannel.close();

        fis.close();
        fos.close();
    }
}
