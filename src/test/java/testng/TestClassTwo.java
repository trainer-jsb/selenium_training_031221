package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClassTwo {
	
  @BeforeClass
  public void setup() {
	  System.out.println("This is the before class of TestClassTwo");
  }
	  
  @Test
  public void testOne_TestClassTwo() {
	  System.out.println("This is the test one_Test class two");
  }
  
  @Test
  public void testTwo_TestClassTwo() {
	  System.out.println("This is the test two_Test class two");
  }

  @AfterClass
  public void tearDown() {
	  System.out.println("This is the after class of TestClassTwo");
  }

}
