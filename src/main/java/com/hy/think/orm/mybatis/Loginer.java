package com.hy.think.orm.mybatis;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * desc: 登录用户
 * @author hy
 * @version 1.0
 * @Created on 2018/3/5 11:51
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("loginer")
public class Loginer {

    private int id;

    private String name;

    private String cryptography;

    private static final Loginer EMPTY = new Loginer(0,"","");

    public static Loginer empty() {
        return EMPTY;
    }
}
