package Landing_Welcome_Page;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.internal.annotations.ITest;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_welcome_postive_script extends Generic_function {
	static boolean value;
	
	/*Browser opens and enter URL*/
	@Given("User opens browser and provide URL")
	public static void browser_launch() throws IOException {
		BrowserLaunch();
	}

	/*TC_001 Verify that user is navigated to the Welcome page */
	@Then("User should be navigated to Welcome page")
	public static void landing_welcome_positive_tc_001() {

		try {
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "welcome_page_msg"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/*TC_002 Validate that the  user is able to click on 'Login' button and navigated to login page*/
	@When("User clicks on the Login button and navigate to Login page")
	public static void landing_welcome_positive_tc_002() throws IOException {
		try {

			click("Login");
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "login_msg"))).isDisplayed();
			Assert.assertEquals(true,value);
			driverClose();
		}catch (IOException e) {
			takeScreenShot(driver, "LoginFail");
			e.getMessage();
		}
	}

	/*TC_003 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page*/
	@When("User clicks on Sign up button and navigate to Sign up page")
	public static void landing_welcome_positive_tc_003() throws IOException { 
		try {
			BrowserLaunch();
			click("SignUp");
			driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "signup_msg"))).isDisplayed();
			Assert.assertEquals(true,value);
			driverClose();
		}catch (IOException e) {
			takeScreenShot(driver, "SignUpFail");
			e.getMessage();
		}
	}

}

