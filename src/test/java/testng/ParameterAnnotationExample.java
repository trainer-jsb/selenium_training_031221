package testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotationExample {
	
	@Parameters({"browser"})
	@Test
	public void firstTest(@Optional("opera")String browser){
		System.out.println("This test will run in " +browser);
	}
	
	@Parameters({"username","password"})
	@Test
	public void secondTest(@Optional("sapient")String username, @Optional("password")String password ){
		System.out.println("Username is " + username+ " and password is " +password);
	}

}
