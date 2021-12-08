package handsonexercises;

import org.testng.annotations.Test;

import util.Utilities;

public class ExcelInteraction {
	
	Utilities util;
	
	@Test
	public void testReadFromExcel()
	{
		Utilities util = new Utilities();
		String fPath= "src/test/resources/TestExcel.xls";
		String sheetName="login";
		int iRow=3, iCol=1;
		String excelValue = util.readFromExcel(fPath, sheetName, iRow, iCol);
		System.out.println(excelValue);
	}

}
