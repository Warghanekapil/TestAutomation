Feature: Login Functionality for OrangeHRM Website
  As a Admin User of the OrangeHRM website
  I want to be able to login in with my admin account
  So that I can access my account related features and manage my operations

Background:
Given User on the OrangeHRM Login Page
  
@Smoketest  
 Scenario: Admin User Default Login 
   Given  Admin entered a valid username and Password
   When  Admin click on login button
   Then Login must be successful
   And Admin click on drop down menu
   And Admin click on logout

@testcase
 Scenario Outline:  UnSuccessfull Admin login with invalid or empty credentials
    Given Admin entered a invalid "<username>" and Password "<password>" 
    When Admin click on login button
    Then Admin should see an error message indicating "<error_message>"

    Examples: 
      | username  | password | error_message|
      | Admin |notadmin5 |Invalid credentials|
      | name2 |admin123 | Invalid credentials|
      | name2 |notadmin5 |Invalid credentials|
      |							|										|Required							|
      
   
@Regression 
Scenario: Admin Navigating to the Forgot Password page
    Given  Click on Forgot your password 
    When Redirected to the password reset page
    And   Enters Username and click on Reset password
    Then A Display message as "A reset password link has been sent to you via email."