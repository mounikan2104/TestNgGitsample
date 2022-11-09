package TestScript;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewConfigurer;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageTest {
	WebDriver driver;
	ExtentReports extentReport;
	ViewConfigurer<ExtentSparkReporter> sparkReport;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtentRep() {
		extentReport=new ExtentReports();
		//sparkReport=new ExtentSparkReporter("target/SparkReport.html");
		sparkReport=new ExtentSparkReporter("target/SparkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.CATEGORY
				});
		
		//extentReport.attachReporter(sparkReport);
	}
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
  //@Test(alwaysRun=true,dependsOnMethods="searchSeleniumTest")
  @Test
	public void searchJavaTest() {
	  //WebDriverManager.chromedriver().setup();
	  //WebDriver driver=new ChromeDriver();
	  //driver.manage().window().maximize();
	  extentTest=extentReport.createTest("Search Java Test");
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.name("q"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(),"Java Tutorial- Google Search" );
  }
	  //WebElement srcBox = driver.findElement(By.name("q"));
	  //srcBox.sendKeys("Java Tutorial");
	  //srcBox.submit();
  @Test(retryAnalyzer=TestRetry.class)
  public void searchSeleniumTest() {
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.name("q"));
	  srcBox.sendKeys("Selenium Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(),"Selenium Tutorial- Google Search" );
	 }
  public void searchAppiumTest() {
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.name("q"));
	  srcBox.sendKeys("Selenium Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(),"Selenium Tutorial- Google Search" );
	  
  }
  @AfterMethod
  public void teardown() {
	  extentTest.assignAuthor("TestLead")
	  		 .assignCategory("Regression")
	  		 .assignDevice(System.getProperty("os.name"))
	  		 .assignDevice(System.getProperty("os.version"));
	  driver.close();
  }
	  @AfterTest
	  public void finishExtent() {
		  extentReport.flush();
	  }
  }
	 