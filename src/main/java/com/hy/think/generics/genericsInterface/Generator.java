package com.hy.think.generics.genericsInterface;

/**
 * desc:
 * @author hy
 * @version 1.0
 * @Created on 2017/6/29 8:38
 */
public interface Generator<T> {
    /**
     *description: 创建T
     *@param
     *@return
     *@author hy
     *@version 1.0
     *@created 2017/6/29 8:39
     */
    T create();
}
