package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage {

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContact;
	
	public contactsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContact() {
		return createContact;
	}
	
	public void getcontactPage()
	{
		createContact.click();
	}

}
