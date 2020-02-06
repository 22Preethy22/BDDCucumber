package utilities;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriver_Generic {
	
	public static void Driver_Close(WebDriver driver)
	{
		driver.close();
	}
	public void Driver_Get(WebDriver driver, String URL)
	{
		driver.get(URL);
	}
	public static void Driver_wait(WebDriver driver,int t)
	{
		driver.manage().timeouts().implicitlyWait( t, TimeUnit.SECONDS);
	}
	public String Get_PageSoruce(WebDriver driver)
	{   
		String source = driver.getPageSource();
		return source;
	}
	public String Get_Title(WebDriver driver)
	{   
		String title = driver.getTitle();
		return title;
	}
	public String Get_WindowHandle(WebDriver driver)
	{   
		String id = driver.getWindowHandle();
		return id;
	}
	public Set<String> Get_WindowHandles_Id(WebDriver driver)
	{   
		Set<String> all_wh = driver.getWindowHandles();
		for(String w:all_wh)
		{
			System.out.println(w);
		}
		return all_wh;
	}
	public int Get_WindowHandles_Size(WebDriver driver)
	{   
		Set<String> all_wh = driver.getWindowHandles();
		int count = all_wh.size();
		return count;
	}
	public ArrayList<String> Get_WindowHandles_Title(WebDriver driver)
	{   
		Set<String> all_wh = driver.getWindowHandles();
		ArrayList<String> t=new ArrayList<String>();
		for(String w:all_wh)
		{
			driver.switchTo().window(w);
			String title = driver.getTitle();
			t.add(title);
			System.out.println(title);
		}
		return t;
	}
	public void Get_WindowHandles_Tab(WebDriver driver, int index)
	{   
		Set<String> all_wh = driver.getWindowHandles();
		ArrayList<String> t=new ArrayList<String>(all_wh);
		String w = t.get(index);
		driver.switchTo().window(w);
	}
	public void Get_WindowHandles_CloseChild(WebDriver driver) throws InterruptedException
	{
		String parent_id =driver.getWindowHandle(); 
		Set<String> all_wh = driver.getWindowHandles();
		all_wh.remove(parent_id); 
		for(String wh:all_wh)
		{
		   driver.switchTo().window(wh);
		   Thread.sleep(2000);
		   driver.close(); 
		}
	}
	public static void Window_Maximize(WebDriver driver)
	{   

       driver.manage().window().maximize();
	}
	public void Window_Minimize(WebDriver driver) throws AWTException
	{
		driver.manage().window().maximize();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_N);
	}
	public void Window_Drag(WebDriver driver,int x, int y)
	{   
		Point p = new Point(x, y);
        driver.manage().window().setPosition(p);
    }
	public void Window_Resize(WebDriver driver,int x, int y)
	{   
		Dimension d = new Dimension(x, y);
        driver.manage().window().setSize(d);
    }
	public void Window_DeleteAllCookies(WebDriver driver)
	{   
		driver.manage().deleteAllCookies();
     }
	public void Navigate_Back(WebDriver driver)
	{   
		driver.navigate().back();
     }
	public void Navigate_Forward(WebDriver driver)
	{   
		driver.navigate().forward();
     }
	public void Navigate_Refresh(WebDriver driver)
	{   
		driver.navigate().refresh();
     }
	public void Navigate_URL(WebDriver driver, String URL)
	{   
		driver.navigate().to(URL);
     }
	public void Window_Quit(WebDriver driver)
	{   
		driver.quit();
     }
	public Alert SwitchTO_Alert(WebDriver driver)
	{   
		Alert a = driver.switchTo().alert();
		return a;
		
     }
	public void SwitchTO_DefaultContent(WebDriver driver)
	{   
		driver.switchTo().defaultContent();
     }
	public void SwitchTO_FrameIndex(WebDriver driver, int index)
	{   
		driver.switchTo().frame(index);
     }
	public void SwitchTO_FrameID(WebDriver driver, String val)
	{   
		driver.switchTo().frame(val);
     }
	public void SwitchTO_FrameWebElement(WebDriver driver, WebElement ele)
	{   
		driver.switchTo().frame(ele);
     }
	public void SwitchTO_ParentFrame(WebDriver driver)
	{   
		driver.switchTo().parentFrame();
	 }
	public String Get_CurrentURL(WebDriver driver)
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	

}
