package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	//declaration

	@FindBy(linkText="Organizations")
	private WebElement OrganizationsEdt;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactEdt;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesEdt;
	
	@FindBy(xpath="themes/softed/images/user.PNG")
	private WebElement AdministrationsEdt;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutEdt;
	
	public  homePage(WebDriver driver)
	
	// Initialization
	{
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getContactEdt() {
		return ContactEdt;
	}


	public WebElement getOpportunitiesEdt() {
		return OpportunitiesEdt;
	}


	public WebElement getAdministrationsEdt() {
		return AdministrationsEdt;
	}


	public WebElement getSignOutEdt(WebDriver driver) {
		return SignOutEdt;
	}


	public WebElement getOrganizationsEdt() {
		return OrganizationsEdt;
	}
	
	public void Oraganisationsclk( )
	{
		OrganizationsEdt.click();
	}
	
	public void Contactclk()
	{
		ContactEdt.click();
	}
	
	public void oportunitiesclk()
	{
		 OpportunitiesEdt.click();
	}
	
	
	public void Administrationsclk()
	{
		AdministrationsEdt.click();
	}
	/**
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	
	public void  logoutofapp(WebDriver driver) throws Throwable
	{
		
		mouseHoverAction(driver,AdministrationsEdt);
		Thread.sleep(1000);
		 SignOutEdt.click();
	}


	private void mouseHoverAction(WebDriver driver, WebElement administrationsEdt2) {
		
	}






	




	


	
	

	




	


	

	


	

	
		
	}


