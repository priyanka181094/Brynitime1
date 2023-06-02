package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	@FindBy(xpath="//a[text()='Order History']")
	private WebElement orderhistoryicon;

	public WebElement getOrderhistoryicon() {
		return orderhistoryicon;
	}
	public  MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void orderhistoryApp()
	{
		orderhistoryicon.click();
	}
	
	

}
