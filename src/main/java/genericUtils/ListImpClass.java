package genericUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener{
	ExtentReports reports;
	ExtentTest test;

	public void onTestFailure(ITestResult result) {
			String mtdName = result.getMethod().getMethodName();
			
//			//simple date
//			SimpleDateFormat simpDate = new SimpleDateFormat("dd mm yyyy");
//			String dateFormat = simpDate.format(new Date());
//			System.out.println(dateFormat);
//			EventFiringWebDriver efire=new EventFiringWebDriver(Baseclass.sdriver);
			
			String sysDate =new Date().toString().replaceAll(":", "-");
			System.out.println(mtdName+"-"+sysDate);
			TakesScreenshot ts=(TakesScreenshot)Baseclass.sdriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dstn = new File("./screenshot/"+mtdName+"-"+sysDate+".png");
			
			try {
				FileUtils.copyFile(src, dstn);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			test.log(Status.FAIL, result.getMethod().getMethodName()+" -->this method failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(dstn.getAbsolutePath());
		
		}
	
		public void onStart(ITestContext context) {
				ExtentSparkReporter spark = new ExtentSparkReporter("./spicejetReport.html");
				spark.config().setTheme(Theme.DARK);
				spark.config().setDocumentTitle("SpiceJEt Automation");
				spark.config().setReportName("Spice jet execution report");
				
				 reports = new ExtentReports();
				 reports.attachReporter(spark);
				reports.setSystemInfo("OS", "windows");
				reports.setSystemInfo("platform","win 10");
				reports.setSystemInfo("Reporter", "Murgesh N B");
				
//				test.log(Status.INFO,"test strated");
		}
		
		public void onTestStart(ITestResult result) {
				 test = reports.createTest(result.getMethod().getMethodName());

		}

		public void onTestSuccess(ITestResult result) {
			test.log(Status.PASS, result.getMethod().getMethodName()+" --> method passed");

		}


		public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, result.getMethod().getMethodName()+" --->method skipped");
			test.log(Status.SKIP, result.getThrowable());

		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub

		}

		public void onFinish(ITestContext context) {
			reports.flush();

		}
}
