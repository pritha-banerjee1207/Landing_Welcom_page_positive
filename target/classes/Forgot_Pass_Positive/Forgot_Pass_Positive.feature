Feature: User can reset password by clicking on Forgot password link

  Scenario: Validate user able to enter ten digit number in Phone Number field and click on the Send Reset Link button
    Given Open browser 
    And User is on Login page
    And User click on forgot password link
    When User enter phone number
    And User clicks on send reset link button
    Then Password reset link sent message displayed
    And User navigates to SignUp page
    
    