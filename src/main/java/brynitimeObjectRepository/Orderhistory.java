package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderhistory {
	@FindBy(xpath="//table[@class='table table-bordered']/tbody//tr[1]//a[contains(.,'Track')]")
	private WebElement tracklink;
	@FindBy(xpath="//table[@class='table table-bordered']/tbody//tr[1]/td[3]//a")
	private WebElement productname;

	public WebElement getProductname() {
		return productname;
	}
	public WebElement getTracklink() {
		return tracklink;
	}
	public  Orderhistory (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void orderhistorytrackApp()
	{
		tracklink.click();
	}
	public String productnameApp()
	{
		return (productname.getText());
	}
	

}
