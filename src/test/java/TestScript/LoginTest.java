package TestScript;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	Properties prop;
	//@Parameters("browser")
	@BeforeMethod
  public void setup()throws IOException{
		String strBrowser;
		prop =new Properties();
		String path=System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		 prop.load(fin);
		 strBrowser = prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
	}
	//@Parameters({"uname","pwd"})
	@Test(dataProvider="loginData")
	public void validLogin(String strName,String strPwd) {
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys(strName);
		driver.findElement(By.id("password")).sendKeys(strPwd);
        driver.findElement(By.className("radius")).click();
        boolean isValid=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
        Assert.assertTrue(isValid);
	}
	//@DataProvider(name="loginData")
	//public Object[][] getData(){
		//return new Object[][] {
			//new Object[] {"tomsmith","SuperSecretPassword!"},
			//new Object[] {"testuser1","welcome1"},
			//new Object[] {"testuser2","welcome2"},
			
		//};
		
//}
	@DataProvider(name="loginData")
	public Object[][] getData()throws CsvValidationException,IOException{
		String path=System.getProperty("user.dir")
				+"//src//test//resources/testData//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String cols[];
		ArrayList<Object>dataList=new ArrayList<Object>();
		while((cols=reader.readNext()) !=null) {
			Object[] record= {cols[0],cols[1]};
			dataList.add(record);
		}
		//ArrayList to Object[][]
		return dataList.toArray(new Object[dataList.size()][]);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
	

	