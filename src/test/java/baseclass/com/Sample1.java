package baseclass.com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sample1 {
	@BeforeClass
	public static void tc1() {
		System.out.println("before class");

	}
	@Before
	public void tc2() {
		System.out.println("before ");

	}
	@Test
	public void tc3() {
		System.out.println("Test1");

	}
	@Test
	public void tc4() {
		System.out.println("Test2");

	}
	@After
	public void tc5() {
		System.out.println("after ");

	}
	@AfterClass
	 public static void tc6() {
		System.out.println("After class");

	}

}
