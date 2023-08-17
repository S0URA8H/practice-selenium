package vtiger.Practice;

import org.testng.annotations.Test;

public class realFromCmdLine {

	@Test
	
	public void read()
	{
		String UN = System.getProperty("username");
		System.out.println(UN);
		String PWD = System.getProperty("PASSWORD");
		System.out.println(UN);
	}

}
