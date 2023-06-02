package brynitimeGenericLibrary;


import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * 
	 * @priyankaghosh
	 */
	//create random class
	public int getRandomNumber()
	{
		Random r=new Random();
		int ranNum=r.nextInt(1000);
		return ranNum;
		
	}
	/**
	 * 
	 * @priyankaghosh
	 */
	//creat currentsystemdate
	public  String  currentSystemDate()
	{
		Date date=new Date();
		String currentsystemdate= date.toString();
		return currentsystemdate;
		
	}
	public String getSystemdate()
	{
		Date date=new Date();
		String currentdate= date.toString();
		String ss[]=currentdate.split(" ");
	int  month=date.getMonth();
		String week= ss[0];
		String cdate= ss[2];
		String year= ss[5];
		String dateformat=month+" "+week+" "+cdate+" "+year;
		return dateformat;
		
		
		
		
		
	}
	

}
