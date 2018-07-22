package com.yjh.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File {

    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream("")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
