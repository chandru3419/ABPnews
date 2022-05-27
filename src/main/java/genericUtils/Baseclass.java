package genericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public WebDriverUtil wLib=new WebDriverUtil();
	
	
	public ExtentReports reports;
	
	@BeforeSuite
	public void configBS(){
		System.out.println("DB connected");
		
		ExtentSparkReporter sparkR = new ExtentSparkReporter("./BaseClassExtent.html");
		sparkR.config().setTheme(Theme.STANDARD);
		sparkR.config().setDocumentTitle("Base Extent Report");
		sparkR.config().setReportName("Report from beforeSuite");
		sparkR.config().setReportName("Murgesh nb");
		
		 reports = new ExtentReports();
		reports.attachReporter(sparkR);
		reports.setSystemInfo("OS", "windows");
	}
	
	@BeforeClass
	public void configBC(){
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sdriver=driver;
	}
	
	@BeforeMethod
	public void configBM(){
		System.out.println("login success");
	}
	
	@AfterMethod
	public void configAM(){
		System.out.println("logout success");
	}
	
	@AfterClass
	public void configAC(){
		driver.quit();
	}
	
	
	@AfterSuite
	public void configAS(){
		System.out.println("DB disconnected");
		reports.flush();
	}

}
