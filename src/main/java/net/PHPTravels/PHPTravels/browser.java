package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class browser {
	
 static Properties p = new Properties();
 @Test
 
	public void Login() throws IOException {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	FileInputStream fis = new FileInputStream("C:\\Users\\Online Test\\git\\Firstproject\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
	p.load(fis);
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
	Logger l=Logger.getLogger("browser");
	
	PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\Firstproject\\PHPTravels\\log4jproperties");
	driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']")).click();
	driver.findElement(By.xpath("//a[@class='dropdown-item tr']")).click();
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(p.getProperty("First_name"));
	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(p.getProperty("Last_name"));
	driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(p.getProperty("mobile_number"));
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(p.getProperty("Email"));
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(p.getProperty("password"));
	driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(p.getProperty("confirm_password"));
	
	driver.findElement(By.xpath("//button[@class='cc-btn cc-dismiss']")).click();
	driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']")).click();
	l.info("registration page");
	

	}

}