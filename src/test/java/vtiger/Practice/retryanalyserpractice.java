package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryanalyserpractice {

	@Test(retryAnalyzer=vtiger.GeneralUtitltiy.retruanalyserimplemetation.class)
	
	public void sample()
	{
		Assert.fail();
		System.out.println("hi");
}
}
