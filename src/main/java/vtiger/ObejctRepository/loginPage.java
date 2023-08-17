package vtiger.ObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	//rule 1 create a seperate pom class for every web page
	
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private  WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	// rule 3 create a constructor to initiate the webleemtns
	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// rule 4 provide getter to access thses web elements

	
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}
	/**
	 * THIS METHOD WILL PERFORM LOGIN OPERATION 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	
	
	public void logintoApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitButton.click();
	}
	
	
	
	
	
	
	

}
