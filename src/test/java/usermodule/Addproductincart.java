package usermodule;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import brynitimeGenericLibrary.BaseClass;
import brynitimeGenericLibrary.ExcelUtility;
import brynitimeGenericLibrary.JavaUtility;
import brynitimeGenericLibrary.PropertfileUtility;
import brynitimeGenericLibrary.WebDriverUtility;
import brynitimeObjectRepository.CategoryPage;
import brynitimeObjectRepository.Homepage;
import brynitimeObjectRepository.LoginPage;
import brynitimeObjectRepository.LogoutPage;
import brynitimeObjectRepository.Productdetailspage;
import brynitimeObjectRepository.Wishlistpage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Addproductincart extends BaseClass {
	@Test

	public void addproduct() throws Throwable
	{
		WebDriver driver=null;
		
		WebDriverUtility wuil=new WebDriverUtility();
		ExcelUtility euil=new ExcelUtility();
		JavaUtility juil=new JavaUtility();
		PropertfileUtility puil=new PropertfileUtility();
		String URL=puil.propertyfileutility("url");
		String USERNAME=puil.propertyfileutility("username");
		String PASSWORD=puil.propertyfileutility("password");
		String BROWSER =puil.propertyfileutility("browser");
		
		
		
		
		
		
//to fetch data from excel
		String inputname=euil. fetchDatafromExcel("Verifyaddtocart",1,0);
		System.out.println(inputname);
		

	

		
		
		//for driver setup
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("Base class is working"+BROWSER+"browser launched succesfully");
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			 //WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge browser is launched");
		}
		else
		{
			System.out.println("invalid browser");
		}
		

		
		//maximize the window
		driver.manage().window().maximize();
		//implycitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//get the url of the application
		driver.get(URL);
		
		//click on login
		//enter username and password and login
		 LoginPage logi=new  LoginPage (driver);
		 logi.logginApp(USERNAME, PASSWORD);
		 
		//click on home majortab
		 Homepage hop=new  Homepage(driver);
		 hop.homeiconApp();
	
		//click on electronics  from dropdown
		 hop.electronicsApp();
		
		//storing all products in list of WebElement and click on particular webelement
			CategoryPage cop=new CategoryPage(driver);
			List<WebElement> allproducts = cop.allproductApp(driver);
		
			for(WebElement product:allproducts)
			{
				String productname=product.getText();
				if(productname.contains(inputname)	)
				{
					System.out.println(productname);
					product.click();	
					break;
					
				}
			}
			
		
		
			//click on wishlist
			Productdetailspage pop=new Productdetailspage(driver);
			pop.productdetailsApp();
		//click on addtocart
			Wishlistpage wop=new Wishlistpage(driver);
			wop.wishlistApp();
	//handle alert
//		Alert alt=driver.switchTo().alert();
//		alt.accept();
			
			
			//click on logout button
			 LogoutPage  lop=new LogoutPage (driver);
			 lop.logoutPageApp();
		
		//verify homepage is dipalying or not
		String homepageurl=driver.getCurrentUrl();
		if(homepageurl.contains("Online_Shopping_Application"))
		{
			
			System.out.println("homepage page is displayed");
		}
		else
		{
			System.out.println("homepage is not  displayed");
		}
		
		
			
		
	}
}
		