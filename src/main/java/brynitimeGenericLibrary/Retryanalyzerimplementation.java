package brynitimeGenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyzerimplementation implements IRetryAnalyzer
{
	int count=0;
	int retry=2;

	public boolean retry(ITestResult result) {
		if(count<retry)
		{
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	

}
