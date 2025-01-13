package basic;

import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {
	public static void main(String []args)
	{
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
	}
}
