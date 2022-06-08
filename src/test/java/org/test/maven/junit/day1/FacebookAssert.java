package org.test.maven.junit.day1;

import java.util.Date;

import org.junit.*;

import org.test.base.BaseClass;


public class FacebookAssert extends BaseClass{
	@BeforeClass
	public static void beforeClass() {
		browserLaunch("chrome");
	}
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	@Before
	public void before() {
		System.out.println("Test starts at......."+new Date());
	}
	@After
	public void after() {
		System.out.println("Test ends at......."+new Date());

	}
	
	
	
}
