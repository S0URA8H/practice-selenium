package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class infoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeadTxt;
	
	public infoPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeadTxt() {
		return orgHeadTxt;
	}
	
	/**
	 * 
	 */

     public String getHeaderText()
{
	return orgHeadTxt.getText();
}
}