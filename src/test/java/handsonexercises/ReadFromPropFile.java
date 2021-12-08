package handsonexercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

public class ReadFromPropFile {
	
  @Test
  public void readFromPropFileTest() throws IOException {
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream("src/test/resources/credentials.prop");
	  prop.load(fis);
	  
	  System.out.println(prop.getProperty("username"));
	  System.out.println(prop.getProperty("browser"));
	  
  }
}
