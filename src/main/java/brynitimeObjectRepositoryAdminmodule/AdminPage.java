package brynitimeObjectRepositoryAdminmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brynitimeGenericLibrary.WebDriverUtility;

public class AdminPage {
	
	public WebElement getInsertproducticon() {
		return insertproducticon;
	}
	@FindBy(xpath="//div[@class='sidebar']//ul[2]/li/a[text()=' Create Category ']")
	public WebElement craetecataegory;
	
	@FindBy(xpath="//input[@placeholder='Enter category Name']")
	public WebElement  cataegorynamefield;
	
	@FindBy(xpath="//button[text()='Create']")
	public WebElement createbutton;
	
	//click on createsubcategory
	
	@FindBy(xpath="//div[@class='sidebar']//ul[2]/li[2]/a[text()='Sub Category ']")
	public WebElement createsubcategory;
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement categorydropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter SubCategory Name']")
	private WebElement subcategoryfield;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createsubcategorybutton;
	
	@FindBy(xpath="//li[@class='nav-user dropdown']")
	private WebElement logoutdropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbutton;
	
	@FindBy(xpath="//div[@class='sidebar']//ul[2]/li[3]/a[text()='Insert Product ']")
	private WebElement insertproducticon;
	
	
	
	
	
	
	
	
	
	public  AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getCraetecataegory() {
		return craetecataegory;
	}
















	public WebElement getCataegorynamefield() {
		return cataegorynamefield;
	}
















	public WebElement getCreatebutton() {
		return createbutton;
	}
















	public WebElement getCreatesubcategory() {
		return createsubcategory;
	}
















	public WebElement getCategorydropdown() {
		return categorydropdown;
	}
















	public WebElement getSubcategoryfield() {
		return subcategoryfield;
	}
















	public WebElement getCreatesubcategorybutton() {
		return createsubcategorybutton;
	}
















	public WebElement getLogoutdropdown() {
		return logoutdropdown;
	}
















	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
















	public void createcategoryApp(String categoryname)
	{
		craetecataegory.click();
		cataegorynamefield.sendKeys(categoryname);
		 createbutton.click();
		
	}
	
	public void createsubcategoryApp(WebDriverUtility wuil,String categoryname,String subcategoryname)
	{
		createsubcategory.click();
		WebElement wb=categorydropdown;
		wuil.selectelementfromDropDown(categoryname,wb);
		 subcategoryfield.sendKeys(subcategoryname);
		 createsubcategorybutton.click();
		
		
	}
	public void logoutApp()
	{
		 logoutdropdown.click();
		 logoutbutton.click();
	}
	public void insertApp()
	{
		insertproducticon.click();
	}
	
	

}
