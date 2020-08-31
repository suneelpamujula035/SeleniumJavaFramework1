package com.Functionalities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogIn {
	
	//LogIn Gmail
	@Test
	public void logIn() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Sunil Java\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
		
		FileInputStream file = new FileInputStream("C:\\SeleniumPractices1\\Gmail_Project_TestNG\\src\\com\\TestData\\Gmail_LogIn.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int Rows = sheet.getLastRowNum();
		
		for(int i=1;i<=Rows; i++)
		{
			XSSFRow CurrentRow = sheet.getRow(i);
			
			String Email = CurrentRow.getCell(0).getStringCellValue();
			String Password = CurrentRow.getCell(1).getStringCellValue();
			
			driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(Email);
			driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
			driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc']//div[@class='VfPpkd-RLmnJb']")).click();
			
			String message = driver.findElement(By.xpath("//div[@id=':2f']")).getText();
			System.out.println(message);
			if(message.equalsIgnoreCase("Valid User"))
			{
				sheet.getRow(i).createCell(2).setCellValue("Pass");
			}
			else
			{
				sheet.getRow(i).createCell(2).setCellValue("Fail");

			}
			FileOutputStream fout = new FileOutputStream("C:\\SeleniumPractices1\\Gmail_Project_TestNG\\src\\com\\TestData\\Gmail_LogIn.xlsx");
			workbook.write(fout);
	    }
		workbook.close();
		
		//Checking Social
		driver.findElement(By.xpath("//div[@id=':2g']")).click();
		Thread.sleep(6000);
		
		//Checking Promotions
		driver.findElement(By.xpath("//div[@id=':2h']")).click();
		Thread.sleep(6000);
		
		//Compose mail
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//textarea[@id=':cf']")).sendKeys("suneelpamujula@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=':bx']")).sendKeys("Resume");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id=':d2']")).sendKeys("Selenium Fresher Resume");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=':df']")).click();
		Thread.sleep(6000);
		
		//Using AutoIT for Uploading file
		Runtime.getRuntime().exec("‪D:\\Sunil Java\\AutoIt\\PractiseScripts\\Gmail.exe");
		Thread.sleep(5000);
		
		//Send file
		driver.findElement(By.xpath("//div[@id=':bn']")).click();
		Thread.sleep(60000);
		
		//LogOut
		driver.findElement(By.xpath("//img[@class='gb_La gbii']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		Thread.sleep(10000);
		driver.quit();

}
}
