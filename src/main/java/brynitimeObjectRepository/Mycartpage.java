package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brynitimeGenericLibrary.WebDriverUtility;

public class Mycartpage {
	@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	private WebElement checkoutbutton;
	@FindBy(xpath="//div[@class='col-md-12 col-sm-12 shopping-cart-table ']//table[@class='table table-bordered']//tbody//tr[1]/td[1]")
	private WebElement removeproductcheckbox;
	@FindBy(xpath="//input[@value='Update shopping cart']")
	private WebElement updateshoopingcart;

	public WebElement getUpdateshoopingcart() {
		return updateshoopingcart;
	}
	public WebElement getRemoveproductcheckbox() {
		return removeproductcheckbox;
	}
	public WebElement getCheckoutbutton() {
		return checkoutbutton;
	}
	public  Mycartpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void checkoutbutton()
	{
		checkoutbutton.click();
	}
	public void RemovecheckboxApp()
	{
		 removeproductcheckbox.click();
	}
	public void updateshoppingApp()
	{
		removeproductcheckbox.click();
	}
	public void handlingalertApp(WebDriverUtility wutil,WebDriver driver)
	{
		wutil.switchToAlertPopupandAccept(driver,"Your Cart hasbeen Updated");
	}

}
