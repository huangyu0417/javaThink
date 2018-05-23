package com.hy.think.arithmetic.sort;

import java.util.Arrays;

/**
 * desc: 选择排序
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/4/25 9:20
 */
public class SelectSort {

    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int len = arr.length;

        for (int i = len - 1; i >= 1; i--) {
            int maxLocation = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[maxLocation] < arr[j]) {
                    maxLocation = j;
                }
            }

            int temp = arr[maxLocation];
            arr[maxLocation] = arr[i];
            arr[i] = temp;

        }

        return arr;
    }

    public static void main(String[] args){
        int[] data = new int[]{34,22,7238,121,33,46,842,2112,442,78,34,56,324,11,1,412,345,6,30};
        selectSort(data);
        System.out.println(Arrays.toString(data));
    }

}
