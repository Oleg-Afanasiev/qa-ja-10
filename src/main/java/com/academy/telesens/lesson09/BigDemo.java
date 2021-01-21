package com.academy.telesens.lesson09;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigDemo {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("12339563045345353535345341233956304534535353534534345345345345345345");
        BigInteger result = number1.add(new BigInteger("1"));
        BigInteger result2 = number1.multiply(number1);
        System.out.println(number1);
        System.out.println(result);
        System.out.println(result2);

        try {
            BigInteger badNumber = new BigInteger("abc");
        } catch (Exception e) {
            System.out.println("Input correct number, plc");
        }

        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("3");
        System.out.println(b1.add(b2));
        System.out.println(b1.divide(b2, 15, RoundingMode.CEILING));

        BigDecimal b3 = new BigDecimal("2");
        BigDecimal b4 = new BigDecimal("2.0");
        System.out.println(b3 == b4);
        System.out.println(b3.equals(b4));
        System.out.println(b3.compareTo(b4) == 0); // возвращает 0, если равны
        System.out.println(b1.compareTo(b4));  // возвращает -1, если <
        System.out.println(b4.compareTo(b1)); // возвращает 1, если >
    }
}
