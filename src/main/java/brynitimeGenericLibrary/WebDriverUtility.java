  package brynitimeGenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//maximizingwindow
	public void maximizethewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//minimizing the window

public void minimizethewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

//wait ungtil page gets load
public void waituntilpagegetsload(WebDriver driver)

{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	// TODO Auto-generated method stub

}
//explicit wait
//wait until elements to be visible
public void waitTillElementsTobevisible(WebDriver driver,WebElement wb)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(wb));
	
}
//wait until elemenet clickable
public void waitTillElementToBeclickable(WebDriver driver,WebElement wb) 
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(wb));
	
}
//wait until alertpopup handled
public void waitForAlertPopUp(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
}
//wait until tiltle to be visisble
public void waitForTitle(WebDriver driver,String title)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleContains(title));
}
//wait until url is visible or not
public void waitForUrl(WebDriver driver,String url)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.urlContains(url));
}
//to ignore nosuch elementexception
public void waitNosuchElemenytException(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.ignoring(NoSuchElementException.class);
}
//Dropdownhandling
public void selectelementfromDropDown(WebElement wb,int index)
{
	Select s =new Select(wb);
	s.selectByIndex(index);
}
public void selectelementfromDropDown(WebElement wb,String value)
{
	Select s =new Select(wb);
	s.selectByValue(value);
}
public void selectelementfromDropDown(String visibletext,WebElement wb)
{
	Select s =new Select(wb);
	s.selectByVisibleText(visibletext);
}
public void getAllOptionsfromDropDown(WebElement wb)
{
	Select s =new Select(wb);
	List<WebElement>allops=s.getOptions();
	for(WebElement option:allops)
	{
		String text=option.getText();
		System.out.println(text);
	}
}
//perform mouseoveractions
public void mouseHoverOnElement(WebDriver driver,WebElement wb)
{
	Actions act=new Actions(driver);
	act.moveToElement(wb).perform();
	
}
public void performrightclick(WebDriver driver,WebElement wb)
{
	Actions act=new Actions(driver);
	act.contextClick(wb).perform();
	
}
public void performdoubleclick(WebDriver driver,WebElement wb)
{
	Actions act=new Actions(driver);
	act.doubleClick(wb).perform();
	
}
//to perfiorm frag and drop action
public void performDragAndDrop(WebDriver driver,WebElement src,WebElement des)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src,des).perform();
}

//to handleframes
public void switchToframe(WebDriver driver,String nameId)
{
	driver.switchTo().frame(nameId);
}
public void fswitchToframe(WebDriver driver,WebElement wb)
{
	driver.switchTo().frame(wb);
}
public void switchToframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
public void switchToframe(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
public void switchTopreviousframe(WebDriver driver)
{
	driver.switchTo().defaultContent();
}

//Hnadling Alertpopup
public String alertpopup(WebDriver driver)
{ 
		
		Alert alt=driver.switchTo().alert();
		String text=alt.getText();
		
		return text;
}
public void  switchToAlertPopupandAccept(WebDriver driver,String text)
{ 
	 
	
		Alert alt=driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("Alert is present");
		}
		else
		{
			System.out.println("Alrt is not present");
		}
		
		alt.accept();
}
public void switchToAlertPopupDismiss(WebDriver driver,String text)
{


Alert alt=driver.switchTo().alert();
if(alt.getText().trim().equalsIgnoreCase(text.trim()))
{
	System.out.println("Alert is present");
}
else
{
	System.out.println("Alrt is not present");
}

alt.dismiss();
}
///file upload popup handle
public void fileupload(WebElement wb,String path)
{
	wb.sendKeys(path);
}
//this method is used to provide ownpollingtime...........concept of fluentwait
public void customWait(int duration,WebElement wb,long pollingtime)
{
	//duration =2
	//polling time=1000
	int count=0;
	while(count<duration)
	{
		try
		{
			wb.click();
			break;
		}
		catch(NoSuchElementException  e)
		{
			try
			{
				Thread.sleep(pollingtime);
			}
			catch(InterruptedException ee)
			{
				ee.printStackTrace();
			}
			count++;
		}
	}
}


//take screenshot
public String takescreenshot(WebDriver driver,String screenshotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	 String localdatetime = LocalDateTime.now().toString().replaceAll(":", "_");
	
	File trg=new File(".\\Screenshot\\"+screenshotName +localdatetime+".png");//taking ssname from caller
	FileUtils.copyFile(src, trg);
	return trg.getAbsolutePath();
}
//switch window
public void switchwindow(WebDriver driver,String title)
{
	Set<String>winids=driver.getWindowHandles();
	for(String id:winids)
	{
		driver.switchTo().window(id);
		String actualtitle=driver.getTitle();
		
		if(actualtitle.contains(title))
		{
			//will perform operation
			break;
	}
}
}
//
public void switchingwindow(WebDriver driver,String url)
{
	Set<String>winids=driver.getWindowHandles();
	Iterator<String>it=winids.iterator();
	while(it.hasNext())
	{
		String wid=it.next();
		driver.switchTo().window(wid);
		String text=driver.getCurrentUrl();
		if(text.contains(url))
		{
			break;
	
			//will perform operation
			
	}
}
}

}



























































































		// TODO Auto-generated method stub

	


