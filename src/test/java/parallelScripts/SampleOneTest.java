package parallelScripts;

import org.testng.annotations.Test;

public class SampleOneTest {
	@Test
	public void testOne() {
		long id=Thread.currentThread().getId();
		System.out.println("testOne in SampleOneTes..."+id);
	}
	@Test
	
  public void testTwo() {
		long id=Thread.currentThread().getId();
		System.out.println("testOne in SampleOneTes..."+id);
  }
	@Test
	
	  public void threeTwo() {
			long id=Thread.currentThread().getId();
			System.out.println("tesThree in SampleOneTes..."+id);
	  }
	@Test
	
	  public void fourTwo() {
			long id=Thread.currentThread().getId();
			System.out.println("testFour in SampleOneTes..."+id);
	  }
}
