package com.academy.telesens.lesson11.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterDemo {
    public static void main(String[] args) {
        String path = "C:/Users/af_oleg/Documents/QA_JA_10/data/write-demo.txt";

        try(PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println("next line");
            pw.println("next line2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
