package testng;

import org.testng.annotations.Test;

public class PriorityAnnotationExample {
	
	@Test(priority = 1, groups={"Regression"})
	public void testOne(){
		System.out.println("Test One");
	}
	
	@Test (priority = 2,groups = {"Regression", "Smoke"})
	public void testTwo(){
		System.out.println("testTwo");
	}
	
	@Test (priority = 3, groups = {"Smoke"})
	public void testThree(){
		System.out.println("testThree");
	}
	
	@Test(priority = 4,groups = {"Regression", "Smoke"})
	public void testFour(){
		System.out.println("testFour");
	}
	
	@Test(priority = 5, groups = {"Regression"})
	public void testFive(){
		System.out.println("testFive");
	}

}
