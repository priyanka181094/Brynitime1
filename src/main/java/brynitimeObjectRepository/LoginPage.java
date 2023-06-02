package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//WebElement for username
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement username;
	//WebElement for password
	
	
	@FindBy(xpath="//div[@class='col-md-6 col-sm-6 sign-in']//form/div[2]/input")
	private WebElement password;
	
	//WebElement for login
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginbutton;
	
	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}
	//Businessutility
	public void logginApp(String iusername,String ipassword)
	{
		username.sendKeys(iusername);
		password.sendKeys(ipassword);
		loginbutton.click();
		
		
	}
	

}
