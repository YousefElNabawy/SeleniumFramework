package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream fileS = null;
	
	public FileInputStream getFileInputStream()
	{
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\Book1.xlsx";
		
		File srcFile = new File(filePath);
		
		try {
			fileS = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: " + e.getMessage());
			System.exit(0);
		}
		return fileS;
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fileS = getFileInputStream();
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileS);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int TotalNumberOfRows = sheet.getLastRowNum() + 1;
		int TotalNumberOfCols = 4;
		
		String[][] arrayOfExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];
		
		for (int i = 0; i<TotalNumberOfRows; i++) 
		{
			for (int j = 0; j<TotalNumberOfCols; j++)
			{
				XSSFRow row = sheet.getRow(i);
				arrayOfExcelData[i][j] = row.getCell(j).toString();	
			}
		}
		
		workbook.close();
		return arrayOfExcelData;
	}
}
