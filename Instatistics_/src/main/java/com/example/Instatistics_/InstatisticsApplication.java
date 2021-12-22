package com.example.Instatistics_;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 *<b>Applicazione</b>
 *
 */
@SpringBootApplication
@ComponentScan({"instatistics.controller" , "instatistics.service"})
public class InstatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstatisticsApplication.class, args);
	} 

}
