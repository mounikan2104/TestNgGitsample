package parallelScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test
  public void testOne() {
	  long id=Thread.currentThread().getId();
	  System.out.println(;
  }
}
