package com.projettic.test;


import com.projettic.dao.EmpDao;
import com.projettic.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception{
        InputStream in = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        EmpDao empDao = session.getMapper(EmpDao.class);

        List<Emp> emps = empDao.findAll();

        for(Emp emp:emps){
            System.out.println(emp.toString());
        }

        session.close();
        in.close();
    }
}
