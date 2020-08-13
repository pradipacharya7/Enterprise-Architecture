package edu.mum.main;


import java.util.List;

import edu.mum.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
  public static void main(String[] args) {

      ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:context/applicationContext.xml");

      UserService userService = (UserService) context.getBean("userServiceImpl");

      User user = new User("Pradip","Acharya","abc@gmail.com",4,false,4);
      userService.save(user);

      user = userService.findByEmail("abc@gmail.com");
      System.out.println();
      System.out.println("        *********  User **********");
      System.out.println("User Name: " + user.getFirstName() +" "+user.getLastName());


  }  
  
 }