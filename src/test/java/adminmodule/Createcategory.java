 package adminmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import brynitimeGenericLibrary.BaseClass;
import brynitimeGenericLibrary.ExcelUtility;
import brynitimeGenericLibrary.JavaUtility;
import brynitimeGenericLibrary.PropertfileUtility;
import brynitimeGenericLibrary.WebDriverUtility;
import brynitimeObjectRepositoryAdminmodule.AdminPage;
import brynitimeObjectRepositoryAdminmodule.Loginpageofadmin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcategory extends BaseClass{
	@Test

	public void craetecategory() throws Throwable
	{
		WebDriver driver=null;
		ExcelUtility euil=new ExcelUtility();
		PropertfileUtility puil=new PropertfileUtility();
		WebDriverUtility wuil=new WebDriverUtility();
		
		JavaUtility juil=new JavaUtility();
		
		String AURL=puil.propertyfileutilityadminmodule("url");
		String AUSERNAME=puil.propertyfileutilityadminmodule("username");
		String APASSWORD=puil. propertyfileutilityadminmodule("password");
		String ABROWSER =puil. propertyfileutilityadminmodule("browser");
		String inputcategory=euil.fetchDatafromExceladmin("inputcategory",1,0);
		String inputsubcategory =euil.fetchDatafromExceladmin("inputsubcategory",1,0);
		if(ABROWSER.equalsIgnoreCase("Chrome"))
		{
			
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("Base class is working"+ABROWSER+"browser launched succesfully");
			
		}
		else if(ABROWSER.equalsIgnoreCase("edge"))
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
		driver.get(AURL);
		
	//login to application
		
		Loginpageofadmin  logo=new Loginpageofadmin (driver);
		logo.loginApp(AUSERNAME, APASSWORD);
	
		
		
		//click on createcategory option
		AdminPage admin=new AdminPage(driver);
		admin.createcategoryApp(inputcategory);
		
		
		
		
		//click on subcategory
		
		admin.createsubcategoryApp(wuil,inputcategory,inputsubcategory);
		
		
		
		//to perform logout
		admin.logoutApp();
		//verify the homepage
		String title=driver.getCurrentUrl();
		if(title.contains("Online_Shopping_Application"))
		{
			
			System.out.println("homepage page is displayed");
		}
		else
		{
			System.out.println("homepage is not  displayed");
		}
		
		
		

	}

}
