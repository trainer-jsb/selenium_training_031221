package testng;

import org.testng.annotations.Test;

public class TestDependencyExample {
	
	@Test(priority = 1, timeOut=3000)
	public void createEmployeeTest() throws InterruptedException{
		System.out.println("Create Employee");
		Thread.sleep(5000);
	}
	
	@Test(priority = 2, dependsOnMethods="createEmployeeTest")
	public void updateEmployeeTest(){
		System.out.println("Update Employee");
	}
	
	@Test (priority = 3, dependsOnMethods="updateEmployeeTest")
	public void deleteEmployeeTest(){
		System.out.println("Delete Employee");
	}

}
