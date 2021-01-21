package com.academy.telesens.lesson04;

import java.util.Arrays;

public class Exc {
    public static void main(String[] args) {
        // 1 Вывести массив строк ["One", "Two", "Three"]
        String[] words_bad = new String[3];
        words_bad[0] = "One";
        words_bad[2] = "Two";
        // ...
        words_bad = new String[] {"One", "Two", "Three"};

        String[] words = {"One", "Two", "Three"};
        for (int i=0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        System.out.println("***for each***");
        for (String word : words) {
            System.out.println(word);
        }

        // 2 Вывести все символы от 'a' до 'z'
        System.out.println("2 Вывести все символы от 'a' до 'z'");
        char first = 'a';
        char last = 'z';
        System.out.println(first);
        System.out.println((int)first);
        System.out.println(last);
        System.out.println((int)last);
        System.out.println("****");
        for(char symb = 'a'; symb <= 'z'; symb++) {
            System.out.print(symb);
            System.out.print(" ");
        }
        System.out.println();
        for(int i = 'a'; i <= 'z'; i++) {
            System.out.print((char)i);
            System.out.print(" ");
        }

        System.out.println("***sort***");
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        System.out.println("***equals***");
        String[] words1 = {"One", "Two", "Three"};
        String[] words2 = {"One", "Two", "Three"};
        System.out.println(Arrays.equals(words1, words2));
        words2[0] = "Hello";
        System.out.println(Arrays.equals(words1, words2));

        System.out.println("Сравнение чисел");
        Integer m1 = 200;
        Integer m2 = 200;
        System.out.println(m1.equals(m2));

    }
}
