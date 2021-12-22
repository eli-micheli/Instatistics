package com.example.Instatistics_;
import instatistics.model.*;
import instatistics.service.InstatisticsServiceImpl;
import instatistics.filters.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.TestCase;

import java.util.ArrayList;

@SpringBootTest
class InstatisticsApplicationTests extends TestCase {
	ArrayList<Post> pp ;
	Caption i1;
	InstatisticsServiceImpl service;
	@BeforeEach
	public void setUp(){
		pp = new ArrayList<Post>();
		i1 = new Caption(pp);
		service = new InstatisticsServiceImpl();
		}
	@Test
	public void TestSuggestion(){
		
		Caption i1 = new Caption(pp);
        assertTrue(i1.Suggestion("sport").equals("#sport"));
	}
	@Test
	public void TestYearFilter() {
	    assertEquals(service.getFilterYear("22000"),pp);
	}
    @AfterEach
	public void tearDown(){};
	
}
