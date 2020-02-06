package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ReadData_Property {

		public static String getproper(String path,String key) throws FileNotFoundException, IOException
		{
			 Properties p = new Properties();
			 p.load(new FileInputStream(path));
			 String data = p.getProperty(key);
			 return data;
			
		}
	}

