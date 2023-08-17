package vtiger.GeneralUtitltiy;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import vtiger.ObejctRepository.homePage;
import vtiger.ObejctRepository.loginPage;

/**
 * This class consists of all the basic configuration annotations for 
 * all the common actions
 * @author user
 *
 */
public class BaseClass {
	
	public static WebDriver sdriver;
	javaUtility jUtil = new javaUtility();
	 excelFileUtiltiy eUtil = new excelFileUtiltiy();
	 propertiesFileUtility pUtil = new propertiesFileUtility();
	 webDriverUtility wUtil = new webDriverUtility();

	public WebDriver driver = null;
	
	@BeforeSuite(groups= {"SmokeSuit","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====== db connection successful ======");
	}
	
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws Throwable
	{
		//Read browser name and URL from property File
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " === Browser launched ===");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " === Browser launched ===");
		} else {
			System.out.println("==== invalid Browser name ====");
		}

		wUtil.maximizewindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//Only used for listener to take screenshot
		 sdriver = driver;

		//Load the URL
		driver.get(URL);
		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		//read username and passowrd from property file
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		loginPage lp = new loginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		
		System.out.println("==== Login Successful ====");
	}


	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
			homePage hp = new homePage(driver);
		hp.logoutofapp(driver);
		
		System.out.println("==== Logout Successful ====");
	}
		
	
	@AfterTest(alwaysRun = true)
	public void amConfig1()
	{
		driver.quit();
		System.out.println(" ========== Browser Closed ========");
	}
		
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====== db connection closed ======");
}
}
