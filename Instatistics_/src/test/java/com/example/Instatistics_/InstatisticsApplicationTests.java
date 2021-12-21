package com.example.Instatistics_;

import instatistics.model.*;
import junit.framework.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstatisticsApplicationTests extends TestCase {
	ArrayList<Post> pp = null;
	Caption i1 = new Caption(pp);
	public InstatisticsApplicationTests(String name){
		super(name);
		}
	@BeforeEach
	public void setUp(){
		//Caption i1 = new Caption(pp);
		}
	
	public void Suggestion(){
		assertEquals(i1.Suggestion("sport"), "#nopainnogain");
		}
    @AfterEach
	public void tearDown(){};
	public static TestSuite suite(){
	TestSuite suite = new TestSuite();
	suite.addTest(new InstatisticsApplicationTests("Suggestion"));
	return suite;
	}
}
