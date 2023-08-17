package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrgansatiosPage {

	//declaration 
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement OrganisationPageEdt;
	
	public createOrgansatiosPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganisationEdt() {
		return OrganisationPageEdt;
	}
	
	
	public void CreateOrganisation()
	{
		OrganisationPageEdt.click();
	}
}
