package testng.dataprovider;

import org.testng.annotations.Test;

public class DataProvider {
	
	@org.testng.annotations.DataProvider(name="dpMethod")
	public Object[][] dpMethod(){
		return new Object[][]{{"Test"},{"ABC"},{"Shubham"},{"Pavan"},{"Tufel"}};
	}
	
  @Test(dataProvider="dpMethod")
  public void testDataProvider(String strInput) {
	  System.out.println(strInput);
  }
  
	@org.testng.annotations.DataProvider(name="data-provider")
	public Object[][] dpMethod1(){
		return new Object[][]{{1,2},{3,4},{5,6}};
	}
  
	@Test(dataProvider="data-provider")
	public void testIntDataProvider(int num1, int num2){
		int sum = num1 + num2;
		System.out.println(sum);
	}
	
	
}
