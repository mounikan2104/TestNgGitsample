package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelSampleTest {
	WebDriver driver;
	Properties prop;
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
				driver= new ChromeDriver();
			}
			else if(strBrowser.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				
			}
			driver.manage().window().maximize();
		}
  @Test
  public void loginTest()throws IOException {
	  driver.get(prop.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(readData("uname"));
		driver.findElement(By.id("password")).sendKeys(readData("pwd"));
		driver.findElement(By.className("radius")).click();
      boolean isValid=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
      Assert.assertTrue(isValid);
	  
  }
  public static String readData(String colName) throws IOException {
	  String colValue="";
	  String path=System.getProperty("user.dir")+"//src//test//resources//testData//loginData.xlsx";
	  FileInputStream fin= new FileInputStream(path);
	  XSSFWorkbook workbook= new XSSFWorkbook(fin);
	  XSSFSheet sheet=workbook.getSheet("loginPageData");
	  int numRows=sheet.getLastRowNum();
	  System.out.println("No.of Rows..."+numRows);
	  for(int i=1;i<=numRows;i++) {
		  XSSFRow row=sheet.getRow(i);
		  if(row.getCell(0).getStringCellValue().equalsIgnoreCase(colName));
		  colValue=row.getCell(1).getStringCellValue();
		  
	  }
	  return colValue;
  }
  
  @AfterMethod
  public void teardown() {
	  driver.close();
	  
  }
}
