package edu.mum.main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.batch.ProductBatch;

@Component 
public class Main {
 
	@Autowired
	ProductBatch productBatch;
	
  public static void main(String[] args) throws Throwable {

    ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");
    	context.getBean(Main.class).mainInternal(context);
  	}
    private void mainInternal(ApplicationContext applicationContext) throws Exception {
 
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println("Starting System " + dateFormat.format(date));  
   
	// ProductBatch will be SCHEDULED if @Scheduled is "active" on ProductBatch Class
	// To invoke it "manually" uncomment the next line... and comment out @Scheduled in ProductBatch
// productBatch.startjob();
	
  }
 }