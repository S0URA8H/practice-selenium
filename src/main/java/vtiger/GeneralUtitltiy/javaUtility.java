package vtiger.GeneralUtitltiy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class javaUtility {

	/**
	 * this method will generate a random number for every execution 
	 * @return
	 */
	
	public int getRandomNumber()
	{
		Random r =new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	public String getSystemDate()
	{
		 Date d = new Date(0, 0, 0);
		 String date=d.toString();
		 return date;
		 
	}
	public String getSystemDateFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		String SimpleDateFormat=dateFormat.format(null);
		return SimpleDateFormat;
	}
	public String getSystemDateInFormat()
	{
		Date d = new Date(0, 0, 0);
		String[] date=d.toString().split("");
		String currentdate=date[2];
		String month= date[1];
		String year=date[5];
		String time=date[3].replace(":", "-");
		
		String dateinformat= currentdate+"_"+month+"_"+year+"_"+time;
		return dateinformat;
		
		
				
	}
	
	

}
