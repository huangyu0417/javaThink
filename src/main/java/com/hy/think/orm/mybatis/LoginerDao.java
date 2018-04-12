package com.hy.think.orm.mybatis;

import org.springframework.stereotype.Repository;

/**
 * desc:登录用户数据库访问接口
 * @author hy
 * @version 1.0
 * @Created on 2018/3/5 11:53
 */

@Repository
public interface LoginerDao {

    void insertLoginer(Loginer loginer);

    void deleteLoginer(int id);

    Loginer selectOne(int id);

}
