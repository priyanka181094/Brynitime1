package brynitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[1]/a[text()='Home']")
	private WebElement homeicon;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a[text()=' Books']")
	private WebElement bookicon;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[3]/a[text()=' Electronics']")
	private WebElement electronicsicon;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]/a[text()=' Fashion']")
	private WebElement fashionbutton;
	@FindBy(xpath="//div[@class='header-top-inner']//li[2]/a")
	private WebElement myaccountbutton;
	@FindBy(xpath="//div[@class='header-top-inner']//li[3]/a")
	private WebElement mywishlistbutton;
	@FindBy(xpath="//div[@class='header-top-inner']//li[4]/a")
	private WebElement mycartbutton;
	@FindBy(xpath="//div[@class='header-top-inner']//li[5]/a")
	private WebElement logoutbutton;
	@FindBy(xpath="//span[text()='Track Order']")
	private WebElement tracordericon;
	@FindBy(xpath="//li[@class='dropdown menu-item']/a[2]")
	private WebElement electronicsdropdown;
	
	
	public  Homepage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}


	public WebElement getHomeicon() {
		return homeicon;
	}


	


	public WebElement getMyaccountbutton() {
		return myaccountbutton;

	}


	


	public WebElement getMywishlistbutton() {
		return mywishlistbutton;
	}


	


	public WebElement getMycartbutton() {
		return mycartbutton;
	}


	

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}


	

	public WebElement getTracordericon() {
		return tracordericon;
	}
	
	


	public WebElement getElectronicsdropdown() {
		return electronicsdropdown;
	}


	//Businessutility
	public void homeiconApp()
	{
		homeicon.click();	
	}
	
	public void myaccountApp()
	{
		 myaccountbutton.click();
	}
	public void myWishlistApp()
	{
		mywishlistbutton.click();
		
	}
	public void mycarticonApp()
	{
		mycartbutton.click();
	}
	public void logoutApp()
	{
		logoutbutton.click();
	}
	public void trackorderApp()
	{
		tracordericon.click();
	}
	public void electronicsApp()
	{
		electronicsdropdown.click();
	}
	
	
	

}
