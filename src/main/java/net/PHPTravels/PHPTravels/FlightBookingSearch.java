package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBookingSearch {
	static Properties p = new Properties();

	 @Test
	public static void main(String[] args) throws IOException, InterruptedException {
	
		// TODO Auto-generated method stub
	

	 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Selenium\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
		p.load(fis);
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		//flight
		driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
		
		
	//enter_location1
	  driver.findElement(By.xpath("//div[@id='s2id_location_from']")).click();
	driver.findElement(By.xpath("//div[@id='s2id_location_from']//a[@class='select2-choice']")).sendKeys(p.getProperty("source_location"));
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='s2id_location_from']//a[@class='select2-choice']")).sendKeys(Keys.ENTER);
		
		//enter_location2
		driver.findElement(By.xpath("//div[@id='s2id_location_to']")).click();
		driver.findElement(By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']")).sendKeys(p.getProperty("dest_location"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']")).sendKeys(Keys.ENTER);
		
		//Departure
		driver.findElement(By.xpath("")).click();
        Thread.sleep(1000);
        String s1=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[7]/nav[1]/div[2] ")).getText();//month
        do
        {
            driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[7]/nav[1]/div[3]/*[1]")).click();//next
            s1=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[7]/nav[1]/div[2]")).getText();//month      
        }
            while(s1.equalsIgnoreCase(p.getProperty("dept_date")));
            List<WebElement> dates=driver.findElements(By.xpath("//div[7]//div[1]//div[1]//div[2]//div[31]"));
            int count=driver.findElements(By.xpath("//div[7]//div[1]//div[1]//div[2]//div[31]")).size();
            System.out.println("count"+count);
            for(int i=0;i<count;i++)
            {
                 String date=driver.findElements(By.xpath("//div[7]//div[1]//div[1]//div[2]//div[31]")).get(i).getText();
                 if(date.equals(p.getProperty("d_date")))
                 {
                     driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div[31]")).click();
                 }
            }
		
		/*//guest
		driver.findElement(By.xpath("//div[@class='col-md-1 form-group go-right col-xs-12']//input[@placeholder='0']")).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//span[3]//button[1]")).sendKeys(p.getProperty("Adult"));
		
		/*driver.findElement(By.xpath("//div[@id='flights']//div[contains(@class,'col-md-3 col-xs-12')]//div[2]//div[1]//div[1]//div[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'row gap-10 mb-15 align-items-end')]//div[2]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'row gap-10 mb-15 align-items-end')]//div[2]//div[1]//div[1]//div[1]//span[3]//button[1]")).sendKeys(p.getProperty("Child"));
		
		driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//span[3]//button[1]")).sendKeys(p.getProperty("infant"));*/
		
		
		// one way
		driver.findElement(By.xpath("//div[@class='iradio_square-grey']//ins[@class='iCheck-helper']")).click();
		//Round trip
		driver.findElement(By.xpath("//div[@class='iradio_square-grey checked']//ins[@class='iCheck-helper']")).click();
		//search
		driver.findElement(By.xpath("//div[contains(@class,'col-md-2 col-xs-12 o1')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]")).click();
		driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
		
	}
}