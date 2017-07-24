package com.hy.think.arithmetic.sort;

import java.util.Arrays;

/**
 * desc: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行n-1次比较
 * Description:因为越大的元素会经由交换慢慢"浮"到数列的顶端(最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(1)
 * 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 * @author hy
 * @version 1.0
 * @Created on 2017/7/20 8:31
 */
public class BubbleSort {

    /**
     *description: 普通冒泡排序
     *@param
     *@return
     *@author hy
     *@version 1.0
     *@created 2017/7/20 8:39
     */
    public static int[] bubbleSort(int[] arg) {
        int len;
        if (arg != null && (len = arg.length) > 1) {
            for (int idx = 0; idx < len - 1; idx++) {
                for (int j = len - 1; j > idx; --j) {
                    if (arg[j] < arg[j-1]) {
                        int temp = arg[j];
                        arg[j] = arg[j-1];
                        arg[j-1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arg));
        }
        return arg;
    }


    /**
     *description: 改进后的冒泡排序，如果一趟遍历未发生交换，说明已是按顺序排列
     *@param
     *@return
     *@author hy
     *@version 1.0
     *@created 2017/7/20 8:40
     */
    public static int[] optimizeBubbleSort(int[] arg) {
        int len;
        boolean exchange = true;
        if (arg != null && (len = arg.length) > 1) {
            for (int idx = 0; idx < len - 1 && exchange; idx++) {
                exchange = false;
                for (int j = len - 1; j > idx; --j) {
                    if (arg[j] < arg[j-1]) {
                        int temp = arg[j];
                        arg[j] = arg[j-1];
                        arg[j-1] = temp;
                        exchange = true;
                    }
                }
            }
            System.out.println(Arrays.toString(arg));
        }
        return arg;
    }

    public static void main(String[] args){
        int[] data = new int[]{34,22,121,33,46,78,34,56,11,4,6,30};
        System.out.println("普通冒泡排序");
        bubbleSort(data);
        System.out.println("改进后冒泡排序");
        optimizeBubbleSort(data);
    }

}
