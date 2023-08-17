package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newContact {

	@FindBy(name="lastname")
	private WebElement newContact;
	
	@FindBy(className="crmButton small save")
	private WebElement savebton;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgLookUp;
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(name="search")
	private WebElement search;
	
	@FindBy(className="dvHeaderText")
	private WebElement contactHeaderText;
	
	
	public newContact (WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getOrgLookUp() {
		return orgLookUp;
	}


	public WebElement getSearchText() {
		return searchText;
	}


	public WebElement getSearch() {
		return search;
	}


	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}


	

	public WebElement getNewContact() {
		return newContact;
	}


	public WebElement getSavebton() {
		return savebton;
	}
	
	public newContact(String lastName)
	{
		newContact.sendKeys(lastName);
	}
	
	public void savebton()
	{
		savebton.click();
	}
	
	public void orgLookUp()
	{
		orgLookUp.click();
	}
	
	public void searchtext(String searchName)
	{
		searchText.sendKeys(searchName);
	}
	
	public void searchnow()
	{
		search.click();
	}
	
	public void contactinfo()
	{
		contactHeaderText.getText();
	}

}
