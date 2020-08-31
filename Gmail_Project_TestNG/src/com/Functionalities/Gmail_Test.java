package com.Functionalities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Gmail_Test {
	
	@Test
	public void logIn() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Sunil Java\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
		
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("suneelpamujula4@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Suneel@sunny035");
		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc']//div[@class='VfPpkd-RLmnJb']")).click();
		

}
}
