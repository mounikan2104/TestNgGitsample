package TestScript;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test(groups="featureOne")
  
  public void searchCypressTest () {
	  System.out.println("CypressTest");
  }
  @Test
  public void searchSeleniumTest() {
	  System.out.println("Selenium Test");
  }
  @Test
  public void searchCucumberTest() {
	  System.out.println("Cucumber Test");
  }
 
}
