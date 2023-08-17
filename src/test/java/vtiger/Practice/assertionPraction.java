package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertionPraction {
	@Test
	public void sampleTest()
	{
		int a=1;
		int b=2;
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(a, b);
		System.out.println("step 3");
		System.out.println("step 4");
		System.out.println("Exception and validation complete");
	}
	
	@Test
	
	public void sampleTest1()
	
	{
		SoftAssert sa=new  SoftAssert();
		int a=1;
		int b=2;
		
		System.out.println("Step 1 ");
		sa.assertEquals(false, true);
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println(" Step 4");
		sa.assertTrue(false);
		System.out.println(" execution and validation complete");
		sa.assertAll();
	}

}
