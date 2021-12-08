package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestClassOne {
  @Test
  public void testOne() {
	  System.out.println("This is testOne");
  }
  
  @Test
  public void testTwo() {
	  System.out.println("This is testTwo");
  }
  
  @Test
  public void testThree() {
	  System.out.println("This is testThree");
  }
  
  @BeforeMethod
  public void roshni() {
	  System.out.println("This is roshni");
  }

  @AfterMethod
  public void apeksha() {
	  System.out.println("This is apeksha");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is afterSuite");
  }

}

//Before Suite
//Before Test
//Before Class
//Before Method
//Test ONe
//After Method
//Before Method
//Test Two
//After Method
//After Class
//After Test
//After Suite

