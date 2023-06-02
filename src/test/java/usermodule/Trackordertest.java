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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import brynitimeObjectRepository.Mycartpage;
import brynitimeObjectRepository.Orderhistory;
import brynitimeObjectRepository.Paymentmethodpage;
import brynitimeObjectRepository.Productdetailspage;
import brynitimeObjectRepository.Wishlistpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Trackordertest extends BaseClass {
	@Test()

	public void trackorder()throws Throwable
	{
		
		WebDriver driver =null;;
		WebDriverUtility wuil=new WebDriverUtility();
		ExcelUtility euil=new ExcelUtility();
		JavaUtility juil=new JavaUtility();
		PropertfileUtility puil=new PropertfileUtility();
		String URL=puil.propertyfileutility("url");
		String USERNAME=puil.propertyfileutility("username");
		String PASSWORD=puil.propertyfileutility("password");
		String BROWSER =puil.propertyfileutility("browser");
		//fetching data from excel
		String inputname=euil. fetchDatafromExcel("Trackorder",1,0);
		System.out.println(inputname);
		
		
		
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
				
				wuil.maximizethewindow(driver);
				
				//implycitwait
				wuil.waituntilpagegetsload(driver);
				
				
				
				//get the url of the application
				driver.get(URL);
				
				
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
				//verify mywishlist is diplayed or not
				String wishlisturls=driver.getCurrentUrl();
				
				//using asstertion for validation
				Assert.assertTrue(wishlisturls.contains("my-wishlist"));
//				
//				if(wishlisturls.contains("my-wishlist"))
//				{
//					
//					System.out.println(" mywishlist  page is displayed");
//				}
//				else
//				{
//					System.out.println("mywishlist  page is  not displayed");
//				}
				//click on Mycart icon
				hop.mycarticonApp();
			
			//click on proceed to checkout to place order
				Mycartpage mop=new Mycartpage(driver);
				mop.checkoutbutton();
			
			
			//click on mode of payment
				 Paymentmethodpage opp=new  Paymentmethodpage(driver);
				 opp.dopaymentApp();
				 
				 
			
			//click on track link 
				 Orderhistory ou=new  Orderhistory(driver);
				 ou.orderhistorytrackApp();
				 
	
			//click on logout button
				 LogoutPage  lop=new LogoutPage (driver);
				 lop.logoutPageApp();
			
			//verify homepage is dipalying or not
			String homepageurl=driver.getCurrentUrl();
			//validation with assertion
			Assert.assertTrue(homepageurl.contains("Online_Shopping_Application"));
			
//			 
//			//takescreenshot
//			wuil.takescreenshot(driver,"trackorder");
			
					
				
				// TODO Auto-generated method stub
		}
			

			}

	
	
