package enzigma_Tasks;

import Utility.BaseClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetPassword_Validation extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		

		// Visit the login page
		preCondition();

		// Visit the forgot password page.
		driver.findElement(By.linkText("Forgot Password?")).click();
		
		// Check for mandatory email field.
		System.out.println("Check for mandatory email field: ");
		
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		String email = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		if (email.contains("Please enter email")) {
			System.out.println("Email is mandatory");
		} else {
			System.out.println("email is not mandatory");
		}
		Thread.sleep(2000);
		postCondition();
		preCondition();
		// Validate email format.
		System.out.println("To Validate email format:  ");
		driver.findElement(By.linkText("Forgot Password?")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement email_Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='messageInputTag']/div/div/abx-email/input)[2]")));
		
		email_Field.sendKeys("akashgatkal123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		String validate_email = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		if (validate_email.contains("Please enter a valid email")) {
			System.out.println("email is not validate");
		} else {
			System.out.println("email is validate");
		}
		postCondition();

		preCondition();
		// Provide a registered email
		System.out.println("for check a registered email: ");
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("(//div[@id='messageInputTag']/div/div/abx-email/input)[2]")).sendKeys("akashgatkal123@gmail.com");
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		String reg_email = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		String Email1 = "Please enter a valid email";
		String email2 = "Please enter email";
		if (reg_email.equals(Email1) && reg_email.equals(email2)) {
			System.out.println("registered failed");
		} else {
			System.out.println("registered successfully");
		}
		postCondition();

		
		preCondition();
		// non-registered email
		System.out.println("for check a non-registered email: ");
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("(//div[@id='messageInputTag']/div/div/abx-email/input)[2]")).sendKeys("akashgatkal1234@gmail.com");
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		String email3 = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		if (email3.contains("User does not exists")) {
			System.out.println("email is non registered");
		} else {
			System.out.println("email is registerd");
		}
		// close the browser
		postCondition();

		preCondition();
		// Invalid email format.
		System.out.println("For Invalid email format.: ");
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("(//div[@id='messageInputTag']/div/div/abx-email/input)[2]")).sendKeys("akashgatkal123gmail.com");
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		String invalid_email = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		if (invalid_email.contains("Invalid email format")) {
			System.out.println("email is valid");
		} else {
			System.out.println("email is Invalid");
		}
		// close the browser
		postCondition();

		
		
		preCondition();
		// Blank email field
		System.out.println("For Blank email field: ");
	
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		String blank_email = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
		if (invalid_email.contains("Please enter email")) {
			System.out.println("email field is blank");
		} else {
			System.out.println("email field is not blank");
		}
		// close the browser
		postCondition();

	}
}
