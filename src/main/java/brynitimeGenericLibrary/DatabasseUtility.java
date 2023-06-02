package brynitimeGenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabasseUtility 
{
	Connection connect=null;
	public  void connecttodatabase(String url,String username,String password)throws Throwable
	{
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connect=DriverManager.getConnection(url);

		
		System.out.println("connection with database");
		
	}
	public void endconnection() throws SQLException
	{
		connect.close();
	}
	
	
	

}
