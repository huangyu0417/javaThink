package com.hy.think.thinking.generics.matrix;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/7/15 14:33
 */
public class IntegerMatrix extends GenericMatrix<Integer> {

    /**
     * description: 两个元素相加
     * @param o1
     * @param o2
     * @return
     * @author hy
     * @version 1.0
     * @created 2017/7/15 13:39
     */
    @Override
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    /**
     * description: 两个元素相乘，由于不知道元素的类型，声明为抽象的，由子类实现
     *
     * @param o1
     * @param o2
     * @return
     * @author hy
     * @version 1.0
     * @created 2017/7/15 13:40
     */
    @Override
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }

    @Override
    protected Integer zero() {
        return 0;
    }

    public static void main(String[] args){
        Integer[][] m1 = new Integer[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        Integer[][] m2 = new Integer[][]{{1,1,1},{-2,2,-2},{3,-3,-3},{4,4,-4}};
        IntegerMatrix integerMatrix = new IntegerMatrix();
        System.out.println("m1 + m2 is");
        printResult(m1,m2,integerMatrix.addMatrix(m1,m2),'+');
    }
}
