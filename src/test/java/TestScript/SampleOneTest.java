package TestScript;

import org.testng.annotations.Test;


public class SampleOneTest {
  @Test(groups="featureOne")
  public void searchPlaywrightTest() {
	  System.out.println("Playwright Test");
	  
  }
  @Test
  public void searchJenkinsTest() {
	  System.out.println("Jenkins Test");
  }
  @Test
  public void searchMavenTest() {
	  System.out.println("Maven Test");
   
}
}
