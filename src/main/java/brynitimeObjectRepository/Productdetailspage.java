package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brynitimeGenericLibrary.WebDriverUtility;

public class Productdetailspage {
	@FindBy(xpath="//a[@data-toggle='tooltip']")
	private WebElement wishlistbutton;
	
	@FindBy(xpath="//div[@class='arrow plus gradient']")
	private WebElement addicon;
	
	@FindBy(xpath="//div[@class='quantity-container info-container']/div/div[3]/a[@class='btn btn-primary']")
	private WebElement addtocarticon;
	

	public WebElement getAddtocart() {
		return addtocarticon;
	}
	public WebElement getAddicon() {
		return addicon;
	}
	public WebElement getWishlistbutton() {
		return wishlistbutton;
	}
	public Productdetailspage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void productdetailsApp()
	{
		wishlistbutton.click();
	}
	public void addiconApp()
	{
		addicon.click();
	}
	public void addtocartApps()
	{
		addtocarticon.click();
	}
	public void handlingalertpopupApp(WebDriverUtility wutil,WebDriver driver)
	{
		wutil.switchToAlertPopupandAccept(driver,"Product has been added to the cart");
	}
	
	

}
