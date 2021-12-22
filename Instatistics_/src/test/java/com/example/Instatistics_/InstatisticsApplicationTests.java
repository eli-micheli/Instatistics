package com.example.Instatistics_;
import instatistics.model.*;
import instatistics.service.InstatisticsServiceImpl;
import instatistics.filters.*;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import instatistics.exception.fieldNotFound;
import instatistics.exception.metodNotFound;
import junit.framework.TestCase;

import java.util.ArrayList;

@SpringBootTest
class InstatisticsApplicationTests extends TestCase {
	ArrayList<Post> arrayPostTest ;
	Caption captionTest;
	InstatisticsServiceImpl serviceTest;
	JSONObject jsonError;
	@SuppressWarnings("unchecked")
	@BeforeEach
	public void setUp(){
		arrayPostTest = new ArrayList<Post>();
		captionTest = new Caption(arrayPostTest);
		serviceTest = new InstatisticsServiceImpl();
		jsonError = new JSONObject();
		jsonError.put("Errore: ", "inserire un tema a scelta tra: sport, insieme o cerimonia");
		}
	@Test
	public void TestCaptionMetod() throws fieldNotFound{
		try {
			serviceTest.getCaption("wrongMetod",null);
			fail("No exception generated");
		} catch (metodNotFound exception) {
			exception.printStackTrace();
		}
	}
	@Test
	public void TestCaptionTheme() throws fieldNotFound, metodNotFound {
		 assertEquals(serviceTest.getCaption("Suggestion","wrongTheme"),jsonError);
	}
	@Test
	public void TestYearFilter() {
	    assertEquals(serviceTest.getFilterYear("22000"),arrayPostTest);
	}
    @AfterEach
	public void tearDown(){};
	
}
