package brynitimeGenericLibrary;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertfileUtility {

	
		

		/**this class consist of greneric methods to read data from property  file
		 * @author priyanka
		 */

		

	
//this method is used to fetch the data from propertyfile
			public String propertyfileutility(String key) throws Throwable
			{
				
				FileInputStream fis=new FileInputStream(IpathConstants.propertyfilepath);
				Properties pro=new Properties();
				pro.load(fis);
				String value=pro.getProperty(key);
				return value;
				// TODO Auto-generated method stub

			}
			//admin module  fetch data
			public String propertyfileutilityadminmodule(String key) throws Throwable
			{
				
				FileInputStream fis=new FileInputStream(IpathConstants. propertyfilepathadmin);
				Properties pro=new Properties();
				pro.load(fis);
				String value=pro.getProperty(key);
				return value;
				// TODO Auto-generated method stub

			}
			
			
			

		}

		// TODO Auto-generated method stub

	


