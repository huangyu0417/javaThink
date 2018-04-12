package com.hy.think.orm.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/3/6 9:52
 */
public class MybatisOrdinaryUse {

    public static void main(String[] args){
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(MybatisOrdinaryUse.class.getClassLoader().getResourceAsStream("mybatis/mybatis-config.xml"));
        SqlSession sqlSession = null;
        try {
            sqlSession = factory.openSession();

            LoginerDao mapper = sqlSession.getMapper(LoginerDao.class);
            Loginer loginer = mapper.selectOne(888);
            System.out.println(loginer);


            sqlSession.commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
