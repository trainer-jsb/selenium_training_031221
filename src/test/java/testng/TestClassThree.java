package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClassThree {
	
  @BeforeClass
  public void setup() {
	  System.out.println("This is the before class of TestClassThree");
  }
	  
  @Test
  public void testOne_TestClassTwo() {
	  System.out.println("This is the test one_Test class three");
  }
  
  @Test
  public void testTwo_TestClassTwo() {
	  System.out.println("This is the test two_Test class three");
  }

  @AfterClass
  public void tearDown() {
	  System.out.println("This is the after class of TestClassthree");
  }

}
