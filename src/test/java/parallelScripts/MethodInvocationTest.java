package parallelScripts;

import org.testng.annotations.Test;

public class MethodInvocationTest {
  @Test(invocationCount=10,threadPoolSize=4,timeOut=2000)
  public void sampleTest () {
	  long id=Thread.currentThread().getId();
	  System.out.println("Customer Registration...."+id);
  }
}
