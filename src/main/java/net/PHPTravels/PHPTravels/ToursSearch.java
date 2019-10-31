package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToursSearch {
	static Properties p = new Properties();
	
@Test
	public void ToursSearch() throws IOException, InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	FileInputStream fis = new FileInputStream("C:\\Users\\Online Test\\git\\Firstproject\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
	p.load(fis);
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
	Logger l=Logger.getLogger("ToursSearch");
	
	PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\Firstproject\\PHPTravels\\log4jproperties");
	driver.findElement(By.xpath("//a[contains(text(),'Tours')]")).click();
	
	driver.findElement(By.xpath("//div[@id='s2id_autogen8']")).click();
	driver.findElement(By.xpath("//div[@id='s2id_autogen8']//a[contains(@class,'select2-choice')]")).sendKeys(p.getProperty("destination"));
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[@id='s2id_autogen8']//a[contains(@class,'select2-choice')]")).sendKeys(Keys.ENTER);
	
	//ToursType
	    driver.findElement(By.xpath("//div[@id='tourtype_chosen']//a[@class='chosen-single']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Private')]")).click();
		
	
	 //Check_in
    driver.findElement(By.xpath("//input[@id='DateTours']")).click();
    Thread.sleep(1000);
    String s1=driver.findElement(By.xpath("//div[1]//nav[1]//div[2] ")).getText();//month
    do
    {
        driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[1]/nav[1]/div[3]/*[1]")).click();//next
        s1=driver.findElement(By.xpath("//div[1]//nav[1]//div[2]")).getText();//month      
    }
        while(s1.equalsIgnoreCase(p.getProperty("check_in")));
        List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
        int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
        System.out.println("count"+count);
        for(int i=0;i<count;i++)
        {
             String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).get(i).getText();
             if(date.equals(p.getProperty("date")))
             {
                 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[contains(text(),"+p.getProperty("date")+")]")).click();
             }
         }
        
        
        //adult
        
		driver.findElement(By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
		
		
		//Search
		//driver.findElement(By.xpath("//button[@class='cc-btn cc-dismiss']")).click();
		driver.findElement(By.xpath("//div[@class='col-md-2 col-xs-12']//button[@class='btn btn-primary btn-block'][contains(text(),'Search')]")).click();
		l.info("Toursearch");
	}	
}
