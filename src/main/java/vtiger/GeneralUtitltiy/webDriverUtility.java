package vtiger.GeneralUtitltiy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class webDriverUtility {

	private static final String TakeScreenhot = null;

	/**
	 * 
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * 
	 * @param driver
	 */
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{ 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 
	 * 
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element, int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);		
	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) 
	{
		Select sel = new Select(element);
		sel.selectByValue(value);	
	}
	
	/**
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * 
	 *
	 * @param driver
	 * @param xOffSet
	 * @param yOffSet
	 */
	public void moveAcrossWebPage(WebDriver driver, int xOffSet, int yOffSet)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xOffSet, yOffSet).click().perform();
	}
	
	/**
	 * 
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	
	/**
	 * 
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");", element);
		
		//js.executeScript("arguments[0].scrollIntoView();", element);
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param text
	 */
	
	public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * 
	 * @param driver
	 * @param nameOrID
	 */
	
	public void handleFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * 
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * 
	 * @param driver
	 */
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will switch the selenium control from parent to child or child to 
	 * parent 
	 * 
	 * @param driver
	 */
	
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	 
	public void switchToWindowMethod(WebDriver driver, String partialWinTitle)
	{
	//step 1 : capture all the user ids
		Set<String> allwindowaids = driver.getWindowHandles();
		//step 2 iterate through individual 
		for (String winID:allwindowaids)
		{
			//SWITCH TO EACH ID AND CAPTURE THE TITLE 
			String currenttitle = driver.switchTo().window(winID).getTitle();
			//step 4 compare the title 
			if(currenttitle.contains(partialWinTitle))
			{
				break;
			}
		}
      
		
	}
	
	public String takescreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot\\"+screenshotName+"png");
		
	Files.copy(src, dst);
	return dst.getAbsolutePath();//attach the screen shot to extent reports
		
	}

	public void switchToParentFrame1(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**W
	 * This method will help to switch the control back to current page 
	 * @param driver
	 */
	public void switchToDefaultPage1(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchwindow(WebDriver driver)
	{
		driver.switchTo().window(null);
	}

	public void switchWindow(WebDriver driver, String string) {
		// TODO Auto-generated method stub
		
	}
}
