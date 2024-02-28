package com.mjc.school;

import com.mjc.school.implementation.AuthorController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.mjc.school");
        AuthorController authorController = ctx.getBean("authorController", AuthorController.class);
        System.out.println(authorController.readAll());

    }
}
