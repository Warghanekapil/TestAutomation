Feature: Admin Actions
  Admin accessing all AdminTasks 

Background:
Given Admin loggedIn on portal
And Click on PIM

  @E2ETEST
  Scenario Outline: Perform Addition of new user
    Given Admin on Personnel Information Management page
    And  Click on Add Employee
    And Click on Checkbox for Creating Login Details
    When Admin entered "<FirstName>" "<LastName>" "<EmployeeID>" "<UserName>" "<Password>"  "<ConfirmPassword>" "<Status>"
    And Click Save 
    #And Add "<Nationality>" "<MaritalStatus>" "<DateofBirth>" "<BloodType>" 
    #And Click Save for Saving Nationality, MaritalStatus and DOB
    #And  Save added BloodType
    Then Click on PIM Tab
    And Validate Emp Creation by Searching Employee Information with "<EmployeeID>" on PIM
    And Perform Logout

    Examples: 
         
     
    | FirstName| LastName|EmployeeID|UserName  |Password|ConfirmPassword|Boolean|
    | Ryan           |Jordan        |2030            |RyanJordan|Test@123|Test@123               |Enabled|
      #| Jordan |Ryan   | 102040 |RyanJordan|102040NewUser|102040NewUser|Enabled|
      
    #| picturePath                                  | 
       #| /src/test/resources/picture/bg.jpg| 
       #|Nationality|MaritalStatus|DateofBirth|BloodType|
      #Denmark    |Married          |1995-02-02|O+             | 
@E2ETEST
Scenario: Delete the Added Employee
Given Validate Emp Creation by Searching Employee Information with "<EmployeeID>" on PIM
When Click on Delete the Employee
Then Admin verifies the Employee deletion with "<EmployeeID>" from system
And Perform Logout

