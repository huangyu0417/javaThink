package com.hy.think.thinking.generics.matrix;

/**
 * desc: 泛型矩阵抽象类
 * @author hy
 * @version 1.0
 * @Created on 2017/7/15 13:36
 */
public abstract class GenericMatrix<E extends Number> {
    /**
     *description: 两个元素相加
     *@param
     *@return
     *@author hy
     *@version 1.0
     *@created 2017/7/15 13:39
     */
    protected abstract E add(E o1,E o2);

    /**
     *description: 两个元素相乘，由于不知道元素的类型，声明为抽象的，由子类实现
     *@param
     *@return
     *@author hy
     *@version 1.0
     *@created 2017/7/15 13:40
     */
    protected  abstract E multiply(E o1,E o2);

    //定义'0'元素
    protected abstract E zero();

    //矩阵乘法
    public E[][] addMatrix(E[][] matrix1,E[][] matrix2) {
        int rowLength = matrix1.length;
        int cellLength = matrix1[0].length;
        if (rowLength != matrix2.length || cellLength != matrix2[0].length){//矩阵行数列数是否相等
            throw new RuntimeException("The matrices do not have the save size!");
        }
        E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];

        for (int i = 0 ; i < rowLength; ++i) {//遍历行
            for (int j = 0; j < cellLength; ++j) {
                result[i][j] = add(matrix1[i][j],matrix2[i][j]);
            }
        }
        return result;
    }

    //矩阵乘法
    public E[][] mutiplyMatrix(E[][] matrix1,E[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {//列数等于行数
            throw new RuntimeException("The matrices do not have compatible size!");
        }
        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; ++i) {
            for (int j = 0; j < matrix2[0].length; ++j) {
                result[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; ++k) {
                    result[i][j] = add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
                }
            }
        }
        return result;
    }

    public static void printResult(Number[][] o1,Number[][] o2,Number[][] o3,char op) {
        for (int i = 0; i < o1.length; ++i) {
            for (int j = 0; j < o1[0].length; ++j) {
                System.out.print(" " + o1[i][j]);
            }

            if (i == o1.length/2) {
                System.out.print(" " + op + " ");
            } else {
                System.out.print("   ");
            }
            for (int j = 0; j < o2[0].length; ++j) {
                System.out.print(o2[i][j]+ " ");
            }
            if (i == o2.length/2) {
                System.out.print(" = ");
            } else {
                System.out.print("   ");
            }
            for (int j = 0; j < o3[0].length; ++j) {
                System.out.print(o3[i][j] + " ");
            }
            System.out.println();

        }
    }
}
