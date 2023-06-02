package adminmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import brynitimeGenericLibrary.ExcelUtility;

import brynitimeGenericLibrary.JavaUtility;
import brynitimeGenericLibrary.PropertfileUtility;

import brynitimeGenericLibrary.WebDriverUtility;
import brynitimeObjectRepositoryAdminmodule.AdminPage;
import brynitimeObjectRepositoryAdminmodule.InserproductPage;
import brynitimeObjectRepositoryAdminmodule.Loginpageofadmin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertProduct {
	@Test

	public void inserproduct()throws Throwable {
		WebDriver driver=null;
		ExcelUtility euil=new ExcelUtility();
		PropertfileUtility puil=new PropertfileUtility();
		WebDriverUtility wuil=new WebDriverUtility();
		
		JavaUtility juil=new JavaUtility();
		
		String AURL=puil.propertyfileutilityadminmodule("url");
		String AUSERNAME=puil.propertyfileutilityadminmodule("username");
		String APASSWORD=puil. propertyfileutilityadminmodule("password");
		String ABROWSER =puil. propertyfileutilityadminmodule("browser");
		//fetch data from excel
		String inputcategory=euil.fetchDatafromExceladmin("inputcategory",1,0);
		String inputsubcategory =euil.fetchDatafromExceladmin("inputsubcategory",1,0);
		String productname=euil.fetchDatafromExceladmin("productname",1,0);
		String priceafterdiscount=euil.fetchDatafromExceladmin("priceafterdiscount",1,0);
		String productpricebeforediscount=euil.fetchDatafromExceladmin("pricebeforediscount",1,0);
		String companyname=euil. fetchDatafromExceladmin("companyname",1,0);
		String description=euil. fetchDatafromExceladmin("description",1,0);
		String shippingcharge=euil. fetchDatafromExceladmin("shippingcharge",1,0);
		String imagepath=euil.fetchDatafromExceladmin("pathtouploadfile",1,0);
		
		
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
		
		//click on inserproduct
		 AdminPage add=new  AdminPage(driver);
		 add.insertApp();
	
	
		
		//click on inserproduct operation
		 InserproductPage in=new  InserproductPage(driver);
		 in.insertProductApp(wuil,inputcategory,inputsubcategory,productname,priceafterdiscount,productpricebeforediscount,companyname,description,shippingcharge,imagepath,"In Stock" );
		 
		 //click on logout
		 add. getLogoutbutton();
		 System.out.println("System logout  succesfully");
		 
		 
		 
			
				
				

	}

}
