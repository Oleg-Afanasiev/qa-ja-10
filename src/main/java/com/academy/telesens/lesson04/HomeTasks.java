package com.academy.telesens.lesson04;

public class HomeTasks {
    public static void main(String[] args) {
        String palindrome = "qwertyytrewq";
        String notPalindrome = "Hello world!";

        System.out.println(isPalindrome(palindrome));
        System.out.println(isPalindrome(notPalindrome));

        System.out.println(countSubs("java programming java java", "java"));

    }

    public static boolean isPalindrome(String testString) {
        for (int i=0, k=testString.length()-1; i < k; i++, k--) {
            if (testString.charAt(i) != testString.charAt(k)) {
                return false; // найдено не соответствие
            }
        } // for

        return true; // цикл закончился => символы равны
    }

    public static int countSubs(String origin, String subs) {
        int count = 0;

        int index = 0;
        while( (index = origin.indexOf(subs, index)) != -1) {
            count++;
            index = index + subs.length();
        }

        return count;
    }
}
