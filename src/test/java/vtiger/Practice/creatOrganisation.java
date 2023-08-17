package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GeneralUtitltiy.excelFileUtiltiy;
import vtiger.GeneralUtitltiy.javaUtility;
import vtiger.GeneralUtitltiy.propertiesFileUtility;
import vtiger.GeneralUtitltiy.webDriverUtility;

public class creatOrganisation {
	
	@Test

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub

		javaUtility jUtil = new javaUtility();
		 excelFileUtiltiy eUtil = new excelFileUtiltiy();
		 propertiesFileUtility pUtil = new propertiesFileUtility();
		 webDriverUtility wUtil = new webDriverUtility();
		 
		 WebDriver driver = null;

			// Step 1: Read all the necessary data

			/* Read data from property File - Common Data */
			String BROWSER = pUtil.getDataFromPropertyFile("browser");
			String URL = pUtil.getDataFromPropertyFile("url");
			String USERNAME = pUtil.getDataFromPropertyFile("username");
			String PASSWORD = pUtil.getDataFromPropertyFile("password");
			
			String ORGNAME = eUtil.getDataFromExcel("demo", 1, 3) +jUtil.getRandomNumber();
			String LASTNAME = eUtil.getDataFromExcel("demo", 3, 3);
			System.out.println(ORGNAME);
			System.out.println(LASTNAME);
			
			
			
			
			// Step 2: Launch the browser - driver is acting based runtime data - RunTime
			// polymorphism
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER + " --- Browser launched");

			} 
			
			else if (BROWSER.equalsIgnoreCase("EdgeDriver")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER + " --- Browser launched");
			} else {
				System.out.println("invalid Browser name");
			}
			
			
			
		
			
			wUtil.maximizewindow(driver);
			wUtil.waitForElementsToLoad(driver);

			// Step 3: Load the URL
			driver.get(URL);

			//step 4 : login to  the Application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			// Step 5: Click on Organizations Link
			driver.findElement(By.linkText("Organizations")).click();
		
			// Step 6: click on Create Organization look up image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			// Step 6: create Organization
			 driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			 WebElement industry = driver.findElement(By.name("industry"));
			 Select sel= new Select(industry);
			 sel.selectByValue("Machinery");
			// Step 7: save
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			// Step 8: Validate for Organization
			 String OrgHeader = driver.findElement(By.className("dvHeaderText")).getText();
			 if(OrgHeader.contains(ORGNAME))
				 
			 {
				 System.out.println("Organization CREATED"); 
				 System.out.println( OrgHeader);
			 }
			 else
			 {
				 System.out.println("Organization failed");
			 }
			/* Create Contact using Organization */
			// step 9: click on contacts link
			 driver.findElement(By.linkText("Contacts")).click();
			// Step 10: Navigate to create contact look up image
			 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			// step 10: Create a contact with mandatory information
			 driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			// driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
			 
			// Step 11: switch to child window
			// wUtil.switchWindow(driver,"Accounts");
			 
			// Step 12: search for Organisation
			// driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
			// driver.findElement(By.name("search")).click();
			// driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click(); // dynamic xpath
			// Step 13: switch the control back to parent window
			// wUtil.switchWindow(driver, "Contacts");
			// Step 14: save
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
			// Step 15: Validate for Organization
			String contctorgheder = driver.findElement(By.className("dvHeaderText")).getText();
			if (contctorgheder.contains(LASTNAME))
			{
				System.out.println("PASS");
				System.out.println(contctorgheder);
			}
			 else {
					System.out.println("Fail");
				}
			//Logout
			WebElement adminmove = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, adminmove);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Logout successfull");
			driver.quit();
	}
}


