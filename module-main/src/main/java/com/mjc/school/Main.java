package com.mjc.school;

import com.mjc.school.config.ApplicationConfig;
import com.mjc.school.helper.Command;
import com.mjc.school.helper.CommandSender;
import com.mjc.school.helper.MenuHelper;
import com.mjc.school.helper.Operations;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            Scanner keyboard = new Scanner(System.in);

            MenuHelper helper = context.getBean(MenuHelper.class);
            CommandSender commandSender = context.getBean(CommandSender.class);

            while (true) {
                try {
                    helper.printMenu();
                    String key = keyboard.nextLine();
                    if (Integer.toString(Operations.EXIT.getOperationNumber()).equals(key)) {
                        System.exit(0);
                    }

                    Command command = helper.getCommand(key, keyboard);
                    Object result = commandSender.send(command);
                    if (result instanceof Iterable it) {
                        it.forEach(System.out::println);
                    } else {
                        System.out.println(result);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
