package com.example.Instatistics_;

import instatistics.model.*;
import junit.framework.*;

import java.util.ArrayList;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstatisticsApplicationTests extends TestCase {
	private Caption i1;
	public InstatisticsApplicationTests(String name){
		super(name);
		}
	
	public void setUp(){
		ArrayList<Post> pp = new ArrayList<Post>();
		Caption i1 = new Caption(pp);
		}
	public void Suggestion(){
		assertEquals(i1.Suggestion("sport"), "#nopainnogain");
		assertEquals(i1.Suggestion("sport"), "#giornatainmovimento");
		assertEquals(i1.Suggestion("sport"), "#sport");
		}
	public void tearDown(){};
	public static TestSuite suite(){
	TestSuite suite = new TestSuite();
	suite.addTest(new InstatisticsApplicationTests("Suggestion"));
	return suite;
	}
}
