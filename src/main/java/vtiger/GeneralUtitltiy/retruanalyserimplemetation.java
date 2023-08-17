package vtiger.GeneralUtitltiy;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retruanalyserimplemetation implements IRetryAnalyzer {
	
	int count=1;
	int retrycount=3;
	

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<=retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

	

}
