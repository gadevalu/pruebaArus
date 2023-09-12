package com.exito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageHome extends Base {
	
	
	By Menuppal = By.xpath("//div[@id='category-menu']");
	By MenuSecundario = By.xpath("//p[@id='undefined-nivel2-Mercado']");
	By Submenu = By.xpath("//li[@id='categorias-nivel2-Dormitorio']");
	By Submenu2 = By.xpath("//a[@id='categorias-nivel3-Cabeceros']");

	public PageHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public void menu() throws InterruptedException {
				
		Thread.sleep(2000);
		click(Menuppal);
		click(MenuSecundario);
				
	}
	
	
}
