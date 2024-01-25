package Testpackage;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_OpenWeb 
{
	public String BaseUrl = "https://opensource-demo.orangehrmlive.com/";
	String driverPath = "C://chromedriver-win64//chromedriver.exe";
	public WebDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
	// set the system property for Chrome driver 
	  System.setProperty("webdriver.chrome.driver", driverPath);
	// Create driver object for CHROME browser
	// Start browser
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(BaseUrl);
	 // input user name
	  WebElement username = driver.findElement(By.name("username"));
	  username.sendKeys("Admin");
	 // input password
	  WebElement password = driver.findElement(By.name("password"));
	  password.sendKeys("admin123");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 // click to login
	  WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	  loginButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 // print account name
	  String accountname = driver.findElement(By.className("oxd-userdropdown-name")).getText();
	  System.out.println(accountname);
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 // Navigate to Admin  page
	 WebElement adminpage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
	 adminpage.click();
	 Thread.sleep(5000);
	driver.quit();  
  }  
  

}
