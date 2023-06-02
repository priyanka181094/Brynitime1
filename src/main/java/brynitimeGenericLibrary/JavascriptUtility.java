 package brynitimeGenericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtility {

	JavascriptExecutor js;//making it global to access in every method
	
	public JavascriptUtility(WebDriver driver) //inistializing nonsattic memeber in constructor
	{
		js=(JavascriptExecutor)driver;
	}
	public void scrollup()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public void scrolldown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoview()",element);
	}
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	public void sendKeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=argument[1]", element,data); 
	}

}
