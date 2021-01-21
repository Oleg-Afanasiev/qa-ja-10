package com.academy.telesens.lesson11.file;

import java.io.*;

public class FileExercise {
    public static void main(String[] args) {
        String pathIn = "C:/Users/af_oleg/Documents/QA_JA_10/data/мужские имена.txt";
        String pathOut = "C:/Users/af_oleg/Documents/QA_JA_10/data/мужские имена_copy.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(pathIn));
            PrintWriter pw = new PrintWriter(new FileWriter(pathOut))) {

            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
