package com.mjc.school;

import com.mjc.school.implementation.AuthorController;
import com.mjc.school.implementation.NewsController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.mjc.school");
        NewsController controller = ctx.getBean("newsController", NewsController.class);
        AuthorController authorController = ctx.getBean("authorController", AuthorController.class);
//        System.out.println(controller.readById(5L));
        authorController.readAll().forEach(System.out::println);
    }
}
