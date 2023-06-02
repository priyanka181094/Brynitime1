package brynitimeObjectRepositoryAdminmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageofadmin 
{
	@FindBy(xpath="//input[@id='inputEmail']")
	public WebElement usernameicon;
	@FindBy(xpath="//input[@id='inputPassword']")
	public WebElement passwordicon;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitbutton;
	
	//initialize 
	public Loginpageofadmin (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsername() {
		return usernameicon;
	}

	public WebElement getPassword() {
		return passwordicon;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	public void loginApp(String username,String password)
	{
		usernameicon.sendKeys(username);
		passwordicon.sendKeys(password);
		submitbutton.click();
		
	}
	

}
