package Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static ChromeDriver driver;

	public static void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://app-staging.nokodr.com/");
	}
	public static void signUp()
	{
		driver.findElement(By.xpath("(//input[@class='slds-input ng-untouched ng-pristine ng-valid'])[3]")).sendKeys("gatkalakash2001@gmail.com");
		driver.findElement(By.className("slds-checkbox__label")).click();
		driver.findElement(By.xpath("//div[@class='slds-col slds-size_1-of-1']")).click();
		
	}

	public static void postCondition() {
		driver.quit();
	}

}