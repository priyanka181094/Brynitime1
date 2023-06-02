package brynitimeGenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listenerimplimentationclass implements ITestListener {


	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) 
	{
//		
//		String screenshotname=result.getMethod().getMethodName();
//		System.out.println(screenshotname+"............the method got failed");
//		TakesScreenshot ts=(TakesScreenshot)BaseClass.ssdriver;
//	File src=ts.getScreenshotAs(OutputType.FILE);
//	String localdatetime=LocalDateTime.now().toString().replace(" ", "_").replace(":", "_");
//	File trg=new File(".\\Screenshottake\\"+" "+localdatetime+screenshotname+".png");
//	try {
//		FileUtils.copyFile(src, trg);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}

