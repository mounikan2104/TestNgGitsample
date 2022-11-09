package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadlessHTMLTest {
	WebDriver driver;
  @Test
  public void searchJava() {
	  driver=new HtmlUnitDriver();
	  driver.get("https://www.google.com/");
	  WebElement srcBox=driver.findElement(By.name("q"));
	  srcBox.sendKeys("Selenium Tutorial");
	  //TakeScreenshot scr=(TakeScreenshot)driver;
	  //File scrFile=scr.getScreenshotAs(OutputType.FILE);
	  //FileUtills.copyFile(srcFile,new File(""))
	  srcBox.submit();
	  System.out.println("Page Title...."+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(),"Selenium Tutorial- Google Search" );
  }
  
}
