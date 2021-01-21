package com.academy.telesens.lesson05;

import java.util.Arrays;

public class ExcString {
    public static void main(String[] args) {
        String data = "18 999 ₴, 29 999 ₴, 19 499 ₴, 26 555 ₴, 22 999 ₴, 27 777 ₴, 36 399 ₴, 23 349 ₴, 57 777 ₴";
        String[] items = data.split(",");
        System.out.println(Arrays.toString(items));
        int[] prices = new int[items.length];

        for(int i=0; i < items.length; i++) {
            String item = items[i] // "18 999 ₴" => "18 999 " => "18999" => 18999
                .replaceAll("₴", "") // "18 999 ₴" => "18 999 "
                .replaceAll(" ", "");// "18 999 " => "18999"
            int price = Integer.parseInt(item); // "18999" => 18999
            prices[i] = price;
        }

//        Необходимо распарсить строку и создать массив цен:
//		[18999, 29999, ...]
        System.out.println(Arrays.toString(prices));
//        Отсортировать массив по возрастанию
        Arrays.sort(prices);
//        Вывести упорядоченные цены на консоль
        System.out.println(Arrays.toString(prices));
    }
}
