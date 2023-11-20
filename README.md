# TestAutomation
Project is an example of BDD Test automation with Java using Cucumber which basicaly is a testing tool that supports behavior-driven development (BDD). 
It contains a simple behavior scenario that performs a test on all the features developed on the considered Web Application.

Purpose
This project was developed to demonstrate how to use Cucumber with BDD test framework.

Version
This project uses cucumber-java, TestNG, cucumber-picocontainer version 7.8.0 and selenium-java version 4.15.0 with extentreports version of above 5.0.0 for creating more insightful reports. 
If using eclipse has updated version of TestNG or similiar to mentioned, please make sure to update to the latest version of the Cucumber for Java plugin. Delete any old Run Configurations if updating, as well.

Web Driver Setup
Project uses Selenium WebDriverManager to interact with the Chrome/Edge/Firefox web browser. 
So no need to have system PATH of web browser for the tests to work.
The source code may easily be changed to work with any other web browser. Just remember to install the required web drivers.

Running Tests
This project uses Maven. To run tests, simply run "mvn clean test".
