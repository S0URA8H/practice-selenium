package vtiger.GeneralUtitltiy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class excelFileUtiltiy {

	

	public String getDataFromExcel(String SheetName, int rowNow,int cellNo) throws Throwable
	{
		
		
		 FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		 Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(SheetName).getRow(rowNow).getCell(cellNo).getStringCellValue();
	
		 wb.close();
		 return value;
				 
	}
	
	//public Cell writeDatFromExcel(String SheetName, int rownow,int cellno) throws Throwable 
	//{
		//FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		// Workbook wb = WorkbookFactory.create(fis);
		 
		// Cell value1= wb.createSheet(SheetName).createRow(rownow).createCell(cellno);
		// wb.close();
		// return value1;
	//}
	
	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws IOException
	 */

	public Object[][] readMultipleData(String SheetName) throws IOException 
	{
	
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(SheetName);
		 int lastrow = sh.getLastRowNum();
		  short lastcell = sh.getRow(0).getLastCellNum();
		 
		 
		 Object[][] data= new  Object[lastrow][lastcell];
		 for(int i=0;i<lastrow;i++)
		 {
			 for(int j=0;j<lastcell;j++)
			 {
				 data[i][j]=sh.getRow(i+1).getCell(j+1).getStringCellValue();
			 }
		 }
		 
		
		return data;
	}
	
	 
	
	
	
}
