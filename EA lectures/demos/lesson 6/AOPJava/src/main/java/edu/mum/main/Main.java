package edu.mum.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.domain.Order;
import edu.mum.service.OrderService;

public class Main {
  public static void main(String[] args) {

 	  ApplicationContext applicationContext = new AnnotationConfigApplicationContext( Persistence.class );
    
    OrderService orderService = (OrderService) applicationContext.getBean("orderServiceImpl");
  
    // Call "adjunct" directly - Logged
    orderService.updateAdjunct();

    
    Order order = new Order();
    order.setOrderNumber("52");
    
   orderService.save(order);
    
   // Call "adjunct" locally from update - NOT Logged
   order.setOrderNumber("102");
    Order mergedOrder = orderService.update(order);
  
    orderService.findAll();
  
  }
 
  }