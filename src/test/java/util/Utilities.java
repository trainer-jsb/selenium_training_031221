package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Utilities {

	String fileExtension;
	Workbook workbook;
	Sheet iSheet;
	FileInputStream iFile;
	FileOutputStream oFile;
	Row oRow;
	Cell oCell;
	String[] arrayName;

	/**
	 * This method will return the string cell value from an excel
	 * 
	 * @param fPath            Complete path for the excel with the file extension
	 * @param sheetName   Sheet name from which the data needs to be read
	 * @param iRow          Row number (not index)
	 * @param iCol           Column number (not index)
	 * @return String value of the cell
	 */
	public String readFromExcel(String fPath, String sheetName, int iRow, int iCol) {
		String cellvalue = null;
		try {
			iFile = new FileInputStream(new File(fPath));
			DataFormatter df = new DataFormatter();
			fileExtension = FilenameUtils.getExtension(fPath);
			workbook = createWorkbook(fileExtension);
			iSheet = workbook.getSheet(sheetName);
			oRow = iSheet.getRow(iRow - 1);
			cellvalue = df.formatCellValue(oRow.getCell(iCol - 1));
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellvalue;
	}

	private Workbook createWorkbook(String extension) throws IOException {
		if (extension.equalsIgnoreCase("xls"))
			workbook = new HSSFWorkbook(iFile);
		else if (extension.equalsIgnoreCase("xlsx"))
			workbook = new XSSFWorkbook(iFile);
		else
			Assert.fail("Incorrect extension provided");
		return workbook;
	}

	/**
	 * Read from properties file
	 * 
	 * @param filename
	 *            prop file name
	 * @param propertyname
	 *            the key from key value pair
	 * @return the value from key value pair
	 * @throws IOException
	 */
	public String readFromPropertiesFile(String filename, String propertyname) throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/" + filename + ".prop");
		// loading properties from properties file
		props.load(fis);
		// reading property
		String propertyvalue = props.getProperty(propertyname);
		return propertyvalue;
	}

}
