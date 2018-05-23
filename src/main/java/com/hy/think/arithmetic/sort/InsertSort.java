package com.hy.think.arithmetic.sort;

import java.util.Arrays;

/**
 * desc: 插入排序
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/4/25 15:41
 */
public class InsertSort {

    public static int[] insertSort(int... arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int len = arr.length;
        int temp;

//        int[] data = new int[]{34,22,7238,121,33,46,842,2112,442,78,34,56,324,11,1,412,345,6,30};
        //外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
        for (int i = 1; i < len; i++) {

            temp = arr[i];

            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较[参考第二趟排序]
            while (i >= 1 && arr[i - 1] > temp) {

                //往后退一个位置，让当前数据与之前前位进行比较
                arr[i] = arr[i - 1];

                //不断往前，直到退出循环
                i--;

            }

            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arr[i] = temp;

        }

        return arr;
    }

    public static void main(String[] args){
        int[] data = new int[]{34,22,7238,121,33,46,842,2112,442,78,34,56,324,11,1,412,345,6,30};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

}
