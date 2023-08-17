package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
	@Test(dataProvider="phones")
	
	public void addtocarttest(String name,int price,String model)
	{
		System.out.println("phone name is "+name+ "price is "+price+ "model is "+model);
	}
	@DataProvider(name="phones")
	public Object[][] getData()
	{
		 Object[][] data=new Object[3][3];
		 
		 data[0][0]="Iphone";
		 data[0][1]=20000;
	     data[0][2]="s13";	
	     
	     data[1][0]="Iphone";
		 data[1][1]=20000;
	     data[1][2]="s13";
	     
	     data[2][0]="Iphone";
		 data[2][1]=20000;
	     data[2][2]="s13";
		return data;
	}
	

}
