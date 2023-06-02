package brynitimeObjectRepositoryAdminmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brynitimeGenericLibrary.IpathConstants;
import brynitimeGenericLibrary.WebDriverUtility;

public class InserproductPage {
	@FindBy(xpath="//select[@name='category']")
	private WebElement categorydropdown;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement subcategorydropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter Product Name']")
	private WebElement productnametextfield;
	
	@FindBy(xpath="//form[@class='form-horizontal row-fluid']/div[4]/div/input[@placeholder='Enter Product Comapny Name']")
	private WebElement companynametextfield;
	
	@FindBy(xpath="//form[@class='form-horizontal row-fluid']/div[5]/div/input[@placeholder='Enter Product Price']")
	private WebElement pricebeforediscount;
	
	@FindBy(xpath="//form[@class='form-horizontal row-fluid']/div[6]/div/input[@placeholder='Enter Product Price']")
	private WebElement priceafterdiscount;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Product Description']")
	private WebElement decription;
	
	@FindBy(xpath="//input[@placeholder='Enter Product Shipping Charge']")
	private WebElement shippingcharge;
	
	@FindBy(xpath="//select[@name='productAvailability']")
	private  WebElement availability;
	
	
	@FindBy(xpath="//input[@name='productimage1']")
	private WebElement fileupload1;
	
	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement fileupload2;
	
	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement fileupload3;
	
	@FindBy(xpath="//form[@class='form-horizontal row-fluid']/div[13]/div/button[text()='Insert']")
	private WebElement insertbutton;
	
	public InserproductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCategorydropdown() {
		return categorydropdown;
	}

	public WebElement getSubcategorydropdown() {
		return subcategorydropdown;
	}

	public WebElement getProductnametextfield() {
		return productnametextfield;
	}

	public WebElement getCompanynametextfield() {
		return companynametextfield;
	}

	public WebElement getPricebeforediscount() {
		return pricebeforediscount;
	}

	public WebElement getPriceafterdiscount() {
		return priceafterdiscount;
	}

	public WebElement getDecription() {
		return decription;
	}

	public WebElement getShippingcharge() {
		return shippingcharge;
	}

	public WebElement getAvailability() {
		return availability;
	}

	public WebElement getFileupload1() {
		return fileupload1;
	}

	public WebElement getFileupload2() {
		return fileupload2;
	}

	public WebElement getFileupload3() {
		return fileupload3;
	}

	public WebElement getInsertbutton() {
		return insertbutton;
	}
	
	public void insertProductApp(WebDriverUtility wuil,String categoryname,String subcategoryname,String productname,String companyname,String pricebf,String priceaf,String des,String shippingcg,String imagepath1,String productavail)
	{
		WebElement wb=categorydropdown;
		wuil.selectelementfromDropDown(categoryname,wb);
		
		//select from subcategorydropdown
		WebElement wb2=subcategorydropdown;
		
		wuil.selectelementfromDropDown(subcategoryname,wb2);
		productnametextfield.sendKeys(productname);
		companynametextfield.sendKeys(companyname);
		pricebeforediscount.sendKeys( pricebf);
		priceafterdiscount.sendKeys(priceaf);
		decription.sendKeys(des);
		shippingcharge.sendKeys(shippingcg);
		
		WebElement wb3=availability;
		wuil.selectelementfromDropDown(productavail,wb3);
		fileupload1.sendKeys(imagepath1);
		fileupload2.sendKeys( imagepath1);
		fileupload3.sendKeys( imagepath1);
		insertbutton.click();
		
		
		
		
	}

}
