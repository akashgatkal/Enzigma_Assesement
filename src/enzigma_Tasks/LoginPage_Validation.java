package enzigma_Tasks;

import Utility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage_Validation extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Visit the login page
		preCondition();

		// Check for mandatory fields (username and password)
		System.out.println("Check for mandatory fields (username and password):   ");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='username']"));
		String validEmail = email.getText();
		if (validEmail.isEmpty()) {
			System.out.println("email is mandatory");
		} else {
			System.out.println("email.is not mandatory");
		}
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		String validPassword = password.getText();
		if (validPassword.isEmpty()) {
			System.out.println("password is mandatory");
		} else {
			System.out.println("password is not mandatory");
		}
		// Ensure password meets length/format requirements
		System.out.println("Ensure password meets length/format requirements:     ");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("akashgatkal123@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Akash@2001");
		driver.findElement(By.xpath("//div[@title='Log In']")).click();
		String e_password = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		if (e_password.contains("Invalid Email or Password")) {
			System.out.println("password format is wrong");
		} else {
			System.out.println("password format is correct");
		}

		postCondition();
		preCondition();
		
		// Correct username and password
		System.out.println("For Correct username and password: ");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("akashgatkal123@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Akash@2001");
		driver.findElement(By.xpath("//div[@title='Log In']")).click();
		System.out.println("login successfully");
		postCondition();
		preCondition();
		// incorrect username and password
		System.out.println("For incorrect username and password: ");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("akashgatkal123@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("agas@2002");
		driver.findElement(By.xpath("//div[@title='Log In']")).click();
		String actual_error = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		String expected_error = "Invalid Email or Password";
		if (actual_error.equals(expected_error)) {
			System.out.println("incorrect username and password");
		} else {
			System.out.println("correct username and password");
		}
		postCondition();
		
		preCondition();
		// Blank fields
		
		System.out.println("Blank fields");
		
		driver.findElement(By.xpath("//div[@title='Log In']")).click();
		String actual_blank_email = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		String expected_blank_email = "Please enter email";
		if (actual_blank_email.equals(expected_blank_email)) {
			System.out.println("fields are blank");
		} else {
			System.out.println("fiels are not blank");
		}

		postCondition();

	}

}
