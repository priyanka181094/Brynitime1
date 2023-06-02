package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlistpage {
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addtocart;

	public WebElement getAddtocart() {
		return addtocart;
	}
	public Wishlistpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void wishlistApp()
	{
		addtocart.click();
	}

}

