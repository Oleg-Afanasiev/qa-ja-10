package com.academy.telesens.lesson03;

import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {
        int[][] array = new int[3][2];
        array[1][0] = 5;
        array[2][1] = 7;
        System.out.println(Arrays.deepToString(array));

        System.out.println("***");
        for(int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
            for(int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
