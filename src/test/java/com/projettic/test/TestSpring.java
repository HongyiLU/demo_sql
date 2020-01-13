package com.projettic.test;

import com.projettic.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext ec = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        EmpService es = (EmpService) ec.getBean("empService");

    }
}
