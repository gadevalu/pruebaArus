package com.exito;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class IngresoTest {
	
	private WebDriver driver;
	PageHome pagehome;
	

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		
		pagehome = new PageHome(driver);
		driver = pagehome.chromeDriverConnnection();
		pagehome.visit("https://www.exito.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	

	@Test
	public void test() throws InterruptedException {
		pagehome.menu();
		
	}
	
}
