package Forgot_Pass_Positive;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forgot_Pass_Positive_Script extends Generic_function{
	
	static WebDriver driver ;

	@Given("Browser open")
	public void browser_open() throws IOException {
		//Generic_function();
		driver= BrowserLaunch();
	}
	
	@And("User is on Login page")
	public void user_is_on_login_page() {
		try {
			driver.navigate().to(getURL());
			driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
			click("Login");
		}catch (IOException e) {
			System.err.println("Caught IOException: " +  e.getMessage());
		}
	}

	@And("User click on forgot password link")
	public void user_click_on_forgot_password_link_page() throws IOException {
		click("ForgotPass");
	}

	@When("User enter phone number")
	public void user_enter_phone_number() throws IOException {
		//driver.findElement(By.xpath(OR_reader("Object Locator", "PhoneNumber"))).sendKeys(td_reader("Test Data",1));
	}

	@And("User clicks on send reset link button")
	public void user_clicks_on_send_reset_link_button() throws IOException {
		click("SendResetLink");
	}

	@Then("Password reset link sent message is displayed")
	public void password_reset_link_sent_message_is_displayed() {
	    
	}

	@And("User navigates to SignUp page")
	public void user_navigates_to_sign_up_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
