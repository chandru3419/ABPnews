package bookFlights;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import genericUtils.Baseclass;
import pomRepo.AddonsPAge;
import pomRepo.BookInfo;
import pomRepo.BookingPage;
import pomRepo.HomePage;

@Listeners(genericUtils.ListImpClass.class)
public class FlightBooking extends Baseclass {
	
	@Test
	public void flightFromTo() throws Throwable{
		
//		ExtentTest test = reports.createTest("flightFromTo()");
		
		HomePage hm=new HomePage(driver);
		hm.getFromTxtfld().sendKeys(Keys.ENTER,"GOI");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		
		//date
		driver.findElement(By.xpath("//div[.='May 2022']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[.='25' and @class='css-76zvg2 r-homxoj r-ubezar r-16dba41']")).click();
		
		//click on search button
		Actions act=new Actions(driver);
		act.click(hm.getSearchBtn()).perform();
		
		//click on continue
		BookingPage pg=new BookingPage(driver);
		act.click(pg.getContBtn()).perform();
		act.click(pg.getPopupClose()).perform();
		act.click(pg.getContBtn()).perform();
		
		//entering details
		Thread.sleep(2000);
		BookInfo info=new BookInfo(driver);
		info.getFirstNameTF().sendKeys("machaa");
		info.getLastNameTF().sendKeys("RCB");
		info.getPhNOTF().sendKeys("9902115140");
		info.getEmailTF().sendKeys("abc@gmail.com");
		info.getCityTF().sendKeys("Bengaluru");
		info.getChkBox().click();
		info.getContBtn().click();
		
		//add ons
		Thread.sleep(14000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div[.='Upto Rs.10000']")));
//		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,300)");
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,300)");
//		js.executeScript("window.scrollBy(0,200)");
//		js.executeScript("window.scrollBy(0,200)");
		AddonsPAge addons=new AddonsPAge(driver);
		System.out.println(addons.getAddOnCont().isDisplayed());
		System.out.println(addons.getAddOnCont().isEnabled());
		
		js.executeScript("arguments[0].click()", addons.getAddOnCont());
		
		act.moveToElement(addons.getAddOnCont()).click(addons.getAddOnCont()).perform();

		addons.getAddOnCont().click();
		
//		act.click(addons.getAddOnCont()).perform();
		
		
//		act.sendKeys(addons.getAddOnCont(),Keys.ENTER).perform();
		
//		wLib.elementToBeClickable(driver, addons.getAddOnCont());

	}
	
//	@Test
//	public void flightToGoa(){
//		
//	}
//	
//	@Test
//	public void thirdFlight(){
//		
//	}
//	
//	@Test
//	public void fourthFlight(){
//		
//	}

}
