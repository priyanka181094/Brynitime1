package brynitimeObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brynitimeGenericLibrary.ExcelUtility;

public class SingupPage {
	
	@FindBy(xpath="//button[@name='submit'] ")
	private WebElement signupbutton;
	
	

	
	
	public WebElement getSignupbutton() {
		return signupbutton;
	}
	public SingupPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}





	//business Lib
	public void signupApp(HashMap<String,String>fields,WebDriver driver)
	{
		for(Entry<String, String> set:fields.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		
	}
	public void singupclick()
	{
		signupbutton.click();
	}
	

}
