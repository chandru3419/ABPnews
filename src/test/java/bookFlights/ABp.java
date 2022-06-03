package bookFlights;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.Baseclass;

public class ABp extends Baseclass {
	
	@Test
	public void drpDwn() throws AWTException, InterruptedException{
		
		for (int i = 1; i <11; i++) 
		{
			wLib.scrollTo(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='left_section position-static'])//a["+i+"]")).click();
			Thread.sleep(3000);
			wLib.scrollTo(driver);
			wLib.scrollTo(driver);
			wLib.scrollTo(driver);
			Thread.sleep(3000);
			
			try {
				driver.switchTo().frame("twitter-widget-0");
				WebElement ele = driver.findElement(By.xpath("(//div[@id='app'])[1]"));
				
				if(ele.isDisplayed()){
					System.out.println("twitter is visible");
					Thread.sleep(2000);
					driver.navigate().back();
				}else
				{
					System.out.println("Not visible");
					Thread.sleep(2000);
					driver.navigate().back();
				}
			}
			catch (Exception e) {
				driver.navigate().back();
			}
			
//			Assert.assertEquals(ele.isDisplayed(), true);
		}	 
	}

}
