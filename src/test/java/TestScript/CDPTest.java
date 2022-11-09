package TestScript;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.devtools.v101.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		devTools=driver.getDevTools();
		devTools.createSession();
	}
		
	
	
  @Test
  public void deviceModeTest() {
	  Map dviceMetrics=new HashMap() {{
		  put("width",600);
		  put("height",1000);
		  put("mobile",true);
		  put("deviceScaleFactor",50);
	  }};
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",dviceMetrics);
	  driver.get("https://www.selenium.dev/");
  }
  @Test
  public void geoLocTest() {
	  devTools.send(Emulation.setGeolocationOverride{
			  Optional.of(33.748997);
			  Optional.of(-84.387985);
			  Optional.of(100);
  }};
  driver.executeCdpCommand("Emulation.setGeolocationOverride",geoLoc);
	  
			  driver.get("https://oldnavy.gap.com/stores");
  }
@Test

public void basicAuthTest() {
	driver.get("http://the-internet.herokuapp.com/basic_auth");
	Map<String,Object> headers = new HashMap<>();
	String strUser="admin";
	String strPwd="admin";
	String basicAuth="Basic "+new String(new Base64().encode(
			String.format("%s:%s",strUser,strPwd).getBytes()));
	System.out.println("Auth...+"+basicAuth);
	headers.put("Authorization", basicAuth);
	devTools.send(Network.setExtraHTTPHeaders(new))
	
}
	  
	  
	  
