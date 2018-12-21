package com.oukele.the_data_jpa;

import com.oukele.the_data_jpa.entity.User;
import com.oukele.the_data_jpa.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = context.getBean(UserService.class);
        User user = service.findNameAndPassword("oukele","oukele");

        System.out.println(user);

    }

}
