package enzigma_Tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseClass;

public class SignUp_Page_Validation extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		preCondition();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Sign up")).click();
		
		// note-here we verify the code manually for getting email verification
		
		signUp();
		
//		for mandatory fields (e.g., name, email, password, confirm password)
		System.out.println(" for mandatory fields (e.g., name, email, password, confirm password) : ");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
		
		
		 WebElement first_name = driver.findElement(By.xpath("//input[@name='firstName']"));
		 first_name.click();
		 
		driver.findElement(By.xpath("//abx-button[@name='register']")).click();
		Thread.sleep(3000);
		
		String name = driver.findElement(By.xpath("//div[text()=' This field is required ']")).getText();
		if (name.contains("This field is required")) {
			System.out.println("field is required");
		} else {
			System.out.println("field is not required");
		}
		driver.findElement(By.xpath("//input[@name='lastName']")).click();
		driver.findElement(By.xpath("//abx-button[@name='register']")).click();
		Thread.sleep(5000);
		String lastname = driver.findElement(By.xpath("//div[text()=' This field is required ']")).getText();
		if (lastname.contains("This field is required")) {
			System.out.println("field is required");
		} else {
			System.out.println("field is not required");
		}
		driver.findElement(By.xpath("//input[@name='password']"));
		String password = driver.findElement(By.xpath("//div[text()=' This field is required ']")).getText();
		if (password.contains("This field is required")) {
			System.out.println("field is required");
		} else {
			System.out.println("field is not required");
		}
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']"));
		String confirm_password = driver.findElement(By.xpath("//div[text()=' This field is required ']")).getText();
		if (confirm_password.contains("This field is required")) {
			System.out.println("field is required");
		} else {
			System.out.println("field is not required");
		}
		driver.findElement(By.xpath("//abx-button[@name='register']")).click();
		
		
		
		
		
//		Validate field-specific formats (e.g., email format, password format)
		System.out.println(" Validate field-specific formats (e.g., email format, password format)");
		
		WebElement v_name = driver.findElement(By.xpath("//input[@name='firstName']"));
		v_name.sendKeys("12345");
		String validate_name = driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']")).getText();
		if (validate_name.contains("Special characters are not allowed")) {
			System.out.println("name format is not correct");
		} else {
			System.out.println("name format is correct");
		}
		WebElement l_name = driver.findElement(By.xpath("//input[@name='lastName']"));
		l_name.sendKeys("12354");
		String validate_lastname = driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']")).getText();
		if (validate_lastname.contains(" Special characters are not allowed ")) {
			System.out.println("password format is not correct");
		} else {
			System.out.println("password format is incorrect");
		}
		postCondition();

		
		
		//Here we check Special Characters
		System.out.println("Here we check Special Characters: ");
		
		preCondition();
		driver.findElement(By.linkText("Sign up")).click();
//		
//		// note-here we verify the code manually
		signUp();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
		
		
		 WebElement fname = driver.findElement(By.xpath("//input[@name='firstName']"));
		 fname.sendKeys("Akash");
//		
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Gatkal");
		WebElement v_password = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
		v_password.sendKeys("Akash@2001");
		
//		String check_password = driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']")).getText();
//		if (check_password.contains(" Special characters are not allowed ")) {
//			System.out.println("password format is not correct");
//		} else {
//			System.out.println("password format is correct");
//		}

		
		
		
		// Ensure confirm password matches the password.
		System.out.println("Ensure confirm password matches the password.");
		
		WebElement c_password = driver.findElement(By.xpath("//input[@name='password']"));
		c_password.clear();
		c_password.sendKeys("Akash@2001");
		WebElement con_password = driver.findElement(By.xpath("//input[@name='password-confirmpassword']"));
		con_password.click();
		con_password.sendKeys("Akas@2001");
		if(c_password.equals(con_password))
		{
			System.out.println("confirm password is matches the password");
			
		}else {
			System.out.println("confirm password is not matches the password");
		}
		
		String ensure_password = driver.findElement(By.xpath("//div[text()=' The password and confirmation password do not match ']")).getText();
		
		if (ensure_password.equals(" The password and confirmation password do not match ")) {
			System.out.println("confirm password is  matches the password");
		} else {
			System.out.println("confirm password is not matches the password");
		}
		postCondition();

		
		
		
		// Correct name, email, password.
		System.out.println("Correct name, email, password:   ");
		
		preCondition();
		driver.findElement(By.linkText("Sign up")).click();
		
		// note-here we verify the code manually
		
		signUp();
		

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
		
		
		 WebElement f_name = driver.findElement(By.xpath("//input[@name='firstName']"));
		 f_name.sendKeys("Akash");driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Gatkal");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Akash@2001");
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).sendKeys("Akash@2001");
		driver.findElement(By.xpath("//abx-button[@name='register']")).click();
		postCondition();
		
		
		
		

		// Invalid email format
		System.out.println("Check for Invalid email format:   ");

		preCondition();
		driver.findElement(By.linkText("Sign up")).click();
		
////		// note-here we verify the code manually
		
		driver.findElement(By.xpath("(//input[@class='slds-input ng-untouched ng-pristine ng-valid'])[3]")).sendKeys("akashgatkal123gmail.com");
	
		WebElement invalid_email = driver.findElement(By.xpath("(//div[@id='messageInputTag']/div)[4]"));
		String text = invalid_email.getText();
		System.out.println(text);

		postCondition();

		// Passwords not matching
		System.out.println("Passwords not matching:  ");
		preCondition();
		//Thread.sleep(10000);
		driver.findElement(By.linkText("Sign up")).click();
		
		
		
		// note-here we verify the code manually
		signUp();
		

		WebDriverWait stop = new WebDriverWait(driver, Duration.ofSeconds(50));
		stop.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
		
		
		 WebElement f_name111 = driver.findElement(By.xpath("//input[@name='firstName']"));
		 f_name111.sendKeys("Akash");driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Gatkal");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Akash@2001");
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).sendKeys("Akas@2001");
		
		WebDriverWait wai2 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wai2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-has-error']")));
		
		WebElement password_match = driver.findElement(By.xpath("//div[@class='slds-has-error']"));
		String pass_Text = password_match.getText();
		System.out.println(pass_Text);
		postCondition();

		
		
//		cases like special characters in names or excessively long inputs
		System.out.println(" cases like special characters in names or excessively long inputs:   ");
		preCondition();
		driver.findElement(By.linkText("Sign up")).click();
		//Thread.sleep(50000);
		signUp();
		// note-here we verify the code manually
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));		
		WebElement i_name = driver.findElement(By.xpath("//input[@name='firstName']"));
	
		i_name.sendKeys("1234");
		WebElement invalid_name = driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']"));
		String fName = invalid_name.getText();
		
		System.out.println(fName+" for First Name");
		
		WebElement la_name = driver.findElement(By.xpath("//input[@name='lastName']"));
		la_name.sendKeys("12345");
		WebElement last_invalid_name = driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']"));
		
		String lName = last_invalid_name.getText();
		
		System.out.println(lName+" For Last Name");
		postCondition();
			
			
			
//			Missing or blank mandatory fields
		 System.out.println(" Missing or blank mandatory fields: ");
			
		preCondition();
		driver.findElement(By.linkText("Sign up")).click();
		
		// note-here we verify the code manually
		signUp();
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstName']")));
//		
		WebElement ec_name = driver.findElement(By.xpath("//input[@name='firstName']"));
		ec_name.sendKeys("12345");
		WebElement edge_case_name = driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
		String text1 = edge_case_name.getText();
		
		System.out.println(text1+" for First name");
		
		WebElement ec_lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		ec_lastname.sendKeys("12345");
		WebElement edge_case_lastname = driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
		String text3 = edge_case_lastname.getText();
		
		System.out.println(text3);
		

		postCondition();
	}

}
