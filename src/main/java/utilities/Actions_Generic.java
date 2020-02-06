package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_Generic {
	
	Actions act;
	
	public Actions_Generic(WebDriver driver)
	{
		act=new Actions(driver);
	}
	
	public void Mouse(WebElement ele)
	{
		act.moveToElement(ele).perform();
	}
	public void Drag_Drop(WebElement source, WebElement target)
	{
		act.dragAndDrop(source, target).perform();;
	}
	public void Double_Click( WebElement ele)
	{
		act.doubleClick(ele).perform();;
	}
	public void Right_Click(WebElement ele)
	{
		act.contextClick(ele).perform();
	}
	public void Right_Click_NewTab(WebElement ele) throws AWTException
	{
		act.contextClick(ele).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_T);  
	}
	public void Right_Click_NewWindow(WebElement ele) throws AWTException
	{
        	act.contextClick(ele).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_W); 
		r.keyRelease(KeyEvent.VK_W);  
	}

}
