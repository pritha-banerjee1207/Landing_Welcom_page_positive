Feature: User must be able to see Welcome Screen,Login and Sign up
   
  Scenario: Validate that the user is navigated to Welcome page
  	Given User opens browser and provide URL
    Then User should be navigated to Welcome page

  Scenario: Validate user is able to click on Login button and navigate to Login page
    When User clicks on the Login button and navigate to Login page
    
  Scenario: Validate user is able to click on Sign Up button and navigate to Sign Up page
    When User clicks on Sign up button and navigate to Sign up page 
    
    