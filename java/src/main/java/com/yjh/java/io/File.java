package com.yjh.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("C:\\Users\\yjh\\code-space\\wccc.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\yjh\\code-space\\hh.txt");

        byte[] buffer = new byte[1024];
        int length;
        try {
            if (-1 != (length = fis.read(buffer))){
                fos.write(buffer, 0, length);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
