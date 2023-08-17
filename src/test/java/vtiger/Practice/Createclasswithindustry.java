package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GeneralUtitltiy.excelFileUtiltiy;
import vtiger.GeneralUtitltiy.javaUtility;
import vtiger.GeneralUtitltiy.propertiesFileUtility;
import vtiger.GeneralUtitltiy.webDriverUtility;
import vtiger.ObejctRepository.CreatingNewOrganization;
import vtiger.ObejctRepository.createOrgansatiosPage;
import vtiger.ObejctRepository.homePage;
import vtiger.ObejctRepository.infoPage;
import vtiger.ObejctRepository.loginPage;

public class Createclasswithindustry {

	 excelFileUtiltiy eUtil = new excelFileUtiltiy();
	    javaUtility jUtil = new javaUtility();
	    propertiesFileUtility pUtil = new propertiesFileUtility();
	    webDriverUtility wUtil = new webDriverUtility();

	    @Test(dataProvider = "getData")
	    public void createMultipleOrg(String ORG, String INDUSTRY)  throws Throwable {

	      WebDriver driver = null;

	      // Step 1: Read all the necessary data

	      /* Read data from property File - Common Data */
	      String BROWSER = pUtil.getDataFromPropertyFile("browser");
	      String URL = pUtil.getDataFromPropertyFile("url");
	      String USERNAME = pUtil.getDataFromPropertyFile("username");
	      String PASSWORD = pUtil.getDataFromPropertyFile("password");

	      /* Read Data from Excel sheet - Test data */
	      String ORGNAME = eUtil.getDataFromExcel("demo", 1, 3)+jUtil.getRandomNumber();
	      String LASTNAME= eUtil.getDataFromExcel("demo", 3, 3);

	      // Step 2: Launch the browser - driver is acting based runtime data - RunTime
	      // polymorphism
	      if (BROWSER.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        System.out.println(BROWSER + " --- Browser launched");

	      } else if (BROWSER.equalsIgnoreCase("firefox")) {
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

	      // Step 4: Login to the Application
	      loginPage lp = new loginPage(driver);
	      lp.logintoApp(USERNAME, PASSWORD);

	      // Step 5: Click on Organizations Link
	      homePage hp = new homePage(driver);
	      hp.oportunitiesclk();

	      // Step 6: click on Create Organization look up image
	       createOrgansatiosPage op = new createOrgansatiosPage(driver);
	      op.CreateOrganisation();

	      // Step 6: create Organization
	      CreatingNewOrganization cnop = new CreatingNewOrganization(driver);
	      cnop.CreatingNewOrganization(ORGNAME, INDUSTRY);

	      // Step 8: Validate
	      infoPage oip = new infoPage(driver);
	      String OrgHeader = oip.getHeaderText();
	      if (OrgHeader.contains(ORGNAME)) {
	        System.out.println("PASS");
	        System.out.println(OrgHeader);
	      } else {
	        System.out.println("Fail");
	      }

	      // Step 9: Logout of Application
	      hp.logoutofapp(driver);
	      System.out.println("Logout successfull");
	    }

	    @DataProvider
	    public Object[][] getData() throws Throwable, IOException {
	      return eUtil.readMultipleData("multipleorg");
	    }

}
