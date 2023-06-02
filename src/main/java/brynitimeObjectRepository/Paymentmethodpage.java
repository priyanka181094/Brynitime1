package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentmethodpage {
	@FindBy(xpath="//div[@class='panel-collapse collapse in']//form/input[2]")
	private WebElement paymentbutton;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement submit;

	public WebElement getPaymentbutton() {
		return paymentbutton;
	}

	public WebElement getSubmit() {
		return submit;
	}
	public Paymentmethodpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void dopaymentApp()
	{
		paymentbutton.click();
		 submit.click();
		
	}
}
