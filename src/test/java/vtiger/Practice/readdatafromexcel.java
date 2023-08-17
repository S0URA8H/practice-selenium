package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class readdatafromexcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Step 1: Load the file in Java readable format   
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		
		//Step 2: Create a workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.createSheet("sheet3");
		Row rw = sh.createRow(2);
		Cell cl = rw.createCell(2);
		
		cl.setCellValue("hanuman");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData2.xlsx");
		wb.write(fos);
		System.out.println("data added");
		wb.close();
		System.out.println("workbook closed");
		

		}
		
		
		
	}

}
