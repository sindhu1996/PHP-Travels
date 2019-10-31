package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExistingUserLogin {

	public static void main(String[] args) throws IOException {
	Properties p = new Properties();
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	FileInputStream fis = new FileInputStream("C:\\Users\\Online Test\\git\\Firstproject\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
	p.load(fis);
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
	Logger l=Logger.getLogger("ExistingUserLogin");
	
	PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\Firstproject\\PHPTravels\\log4jproperties");
	driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']")).click();
	driver.findElement(By.xpath("//a[@class='dropdown-item active tr']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(p.getProperty("Email"));
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(p.getProperty("password"));
	//driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']")).click();
	l.info("login page");

	}

}
