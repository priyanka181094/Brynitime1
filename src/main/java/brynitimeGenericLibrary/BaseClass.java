package brynitimeGenericLibrary;



import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import brynitimeObjectRepository.LoginPage;
import brynitimeObjectRepository.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;






public class BaseClass {
	WebDriverUtility wuil=new WebDriverUtility();
	PropertfileUtility puil=new PropertfileUtility();
	ExcelUtility euil=new ExcelUtility ();
	DatabasseUtility duil=new  DatabasseUtility();
	public WebDriver driver;
	
	@BeforeSuite()
	
	public void bsconfig() throws Throwable
	{
		
		//duil.connecttodatabase(IpathConstants.mysqlurl,IpathConstants.mysqlusername,IpathConstants.mysqlpassword);
		System.out.println("Database connected");
	}
	//@Parameters("browsername")
	
	@BeforeClass()
	public void bcconfig() throws Throwable
	{
		String browsername=puil.propertyfileutility("browser");
		String url=puil.propertyfileutility("url");
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
			 System.out.println("Base class is working"+browsername+"browser launched succesfully");
			
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			  WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge browser is launched");
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		
	
	wuil.maximizethewindow(driver);
	
	}
	
	@BeforeMethod()
	public void bmconfig() throws Throwable 
		{
		String username=puil.propertyfileutility("username");
		String password=puil.propertyfileutility("password");
		String url=puil.propertyfileutility("url");
		driver.get(url);
		wuil.waituntilpagegetsload(driver);
		
		
		 LoginPage  logo=new LoginPage (driver);
		 logo.logginApp(username,password);	
		 System.out.println("login successfull");
	}
	@AfterMethod
	public void amconfig()
	{
		 LogoutPage logout=new  LogoutPage(driver);
		 logout.logoutPageApp();
		System.out.println("logout successfully");
	}
	
	@AfterClass
	public void  acConfig()
	{
		driver.close();
		System.out.println("........browser closed.......");
	}
	
	
	
	
	
	
	
	@AfterSuite
	public void acconfig() throws SQLException
	{
		//duil.endconnection();
		 
		System.out.println("database connection closed");
	}
	

}
