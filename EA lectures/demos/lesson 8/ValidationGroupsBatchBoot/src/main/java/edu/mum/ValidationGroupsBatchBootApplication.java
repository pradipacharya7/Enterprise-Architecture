package edu.mum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidationGroupsBatchBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ValidationGroupsBatchBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting System " + dateFormat.format(date));  
 
		// ProductBatch will be SCHEDULED if @Scheduled is "active" on ProductBatch Class
		// To invoke it "manually" uncomment the next line... and comment out @Scheduled in ProductBatch
	// productBatch.startjob();

	}	

}
