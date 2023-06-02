package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//div[@class='header-top-inner']//li[5]/a")
	private WebElement logoutbutton;

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
public LogoutPage (WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public void logoutPageApp()
{
	logoutbutton.click();
}
	
	
	

}
