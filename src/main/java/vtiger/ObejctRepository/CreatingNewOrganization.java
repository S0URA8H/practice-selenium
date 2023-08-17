package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganization {
	
	@FindBy(xpath="//input[@name='accountname']")
	private  WebElement OrganizationName;	
	
	@FindBy(xpath="//select[@name='industry']")
	private  WebElement industryName;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private  WebElement saveBtn;
	
public CreatingNewOrganization (WebDriver driver)
	
	// Initialization
	{
		PageFactory.initElements(driver, this);
	}

public WebElement getOrganizationName() {
	return OrganizationName;
}

public WebElement getIndustryName() {
	return industryName;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public CreatingNewOrganization(String OrgName )
{
	OrganizationName.sendKeys(OrgName);
	saveBtn.click();
}
/**
 * 
 * 
 * 
 */
	public void CreatingNewOrganization(String OrgName, String industry)
	{
		OrganizationName.sendKeys(OrgName);
		handleDropDown(industryName,industry);
		saveBtn.click();
	}

private void handleDropDown(WebElement industryName2, String industry) {
	// TODO Auto-generated method stub
	
}
}
