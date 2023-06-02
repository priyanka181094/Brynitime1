package brynitimeObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	@FindBy(xpath="//div[contains(@class,'category-product  inner-top-vs')]//div[@class='product-info text-left']//a")
	private WebElement allproducts;

//	public WebElement getAllproducts() {
//		return allproducts;
//	}
	public  CategoryPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public List<WebElement> allproductApp(WebDriver driver)
	{
		List<WebElement> allproducts=driver.findElements(By.xpath("//div[contains(@class,'category-product  inner-top-vs')]//div[@class='product-info text-left']//a"));
		return allproducts;
	}
}
