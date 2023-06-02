package usermodule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import brynitimeObjectRepository.MyAccountPage;
import brynitimeObjectRepository.Mycartpage;
import brynitimeObjectRepository.Orderhistory;
import brynitimeObjectRepository.Paymentmethodpage;
import brynitimeObjectRepository.Productdetailspage;
import brynitimeObjectRepository.Wishlistpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Displayorderedproduct extends BaseClass {
	@Test

	public void diplayproduct() throws Throwable
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
		String productinputname=euil. fetchDatafromExcel("Displayproduct",1,0);
		System.out.println(productinputname);
		

	

		
		
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
			//enter username and password
			LoginPage logo=new LoginPage(driver);
			logo.logginApp(USERNAME,PASSWORD);
			
			
			//click on home majortab
			Homepage homo=new Homepage(driver);
			homo.homeiconApp();

			//click on electronics  from dropdown
			homo.electronicsApp();
			
			
			
			//verify homepage is displayed or not
			String homeurl=driver.getCurrentUrl();
			if(homeurl.contains("Online_Shopping_Application"))
			{
				
				System.out.println("homepage page is displayed");
			}
			else
			{
				System.out.println("home page is not  displayed");
			}
			//click on electronics  from dropdown
			homo.electronicsApp();
			
			//storing all products in list of WebElement and click on particular webelement
			CategoryPage cop=new CategoryPage(driver);
			List<WebElement> allproducts = cop.allproductApp(driver);
		
			for(WebElement product:allproducts)
			{
				String productname=product.getText();
				if(productname.contains(productinputname)	)
				{
					System.out.println(productname);
					product.click();	
					break;
					
				}
			}
			
			
			  	//click on wishlist
			Productdetailspage pu=new Productdetailspage(driver);
			pu.productdetailsApp();
			
			
			
			//verify add to cart page is displaying or not
			Wishlistpage wo=new Wishlistpage(driver);
			wo.wishlistApp();
			
			
			//verify mywishlist is diplayed or not
			String wishlisturls=driver.getCurrentUrl();
			if(wishlisturls.contains("my-wishlist"))
			{
				
				System.out.println(" mywishlist  page is displayed");
			}
			else
			{
				System.out.println("mywishlist  page is  not displayed");
			}
			
			//click on Mycart icon
			
			homo.mycarticonApp();
			
		
		//verify mycart page is diaplaying or not
		String mycarturl2=driver.getCurrentUrl();
		if(mycarturl2.contains("my-cart"))
		{
			
			System.out.println(" mycart page is displayed");
		}
		else
		{
			System.out.println("mycart  page is  not displayed");
		}
		
		//click on proceed to checkout to place orde
		Mycartpage my=new Mycartpage(driver);
		my.checkoutbutton();
		//click on mode of payment
		 Paymentmethodpage opp=new  Paymentmethodpage(driver);
		 opp.dopaymentApp();
		
		
		 //click on myaccount module
		 homo.myaccountApp();
		
		//click on orderhistory
		 MyAccountPage  mor=new MyAccountPage (driver);
		 mor.orderhistoryApp();
		
		//checking order is placed or not
		 Orderhistory ord=new Orderhistory (driver);
		 String displaytext= ord.productnameApp();
		
		
		if(displaytext.contains(productinputname))
		{
			System.out.println("product successfully placed");
		}
		else
		{
			System.out.println("product successfully  not placed");
		}
		//click on logout button
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
	
				
			
			// TODO Auto-generated method stub
	}
		


}

