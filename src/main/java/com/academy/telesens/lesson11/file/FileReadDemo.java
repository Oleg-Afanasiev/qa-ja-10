package com.academy.telesens.lesson11.file;

import java.io.*;
import java.util.Scanner;

public class FileReadDemo {
    public static void main(String[] args) {
        String path = "C:/Users/af_oleg/Documents/QA_JA_10/data/мужские имена.txt";

        // 1 Способ
        System.out.println("1 Способ");
        try(InputStream is = new FileInputStream(path)) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // 2 Способ
        System.out.println("2 Способ");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
