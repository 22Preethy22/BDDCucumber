package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static void GetScreenShot(WebDriver driver,String tcn) throws IOException  {
		   String path="target/photos/";
		   
		   DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		  
		  //get current date time with Date()
		  Date date = new Date();
		  
		  // Now format the date
		  String date1= dateFormat.format(date);
		   
		/*Date d = new Date(); // Current system date it will capture 
		String d1=d.toString(); // convert from DAte to string 

		   String date=d1.replaceAll(":","-"); // Replace : with - in date 
		*/
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(path+tcn+date1+".jpeg");
		
		FileUtils.copyFile(src, dst);
		

		
		}

		}  