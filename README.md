# Selenium Hybrid Framework for NopCommerce
## Overview
This Selenium Hybrid Framework is designed for automated testing of the NopCommerce website. It combines the advantages of data-driven and keyword-driven testing approaches to provide a flexible and scalable solution for automated testing.

## Framework Structure
### 1. Core Components
 * Common package: Contains common classes and constants used across the framework.
 * Base Page: Encapsulates methods to interact with web elements such as clicking, typing text, selecting options, verifying element presence, etc. Serves as the foundation for all page objects.
 * Base Test: Encapsulates common methods such as launching and closing the browser, configuring the browser environment, handling errors or failures, etc.Serves as the foundation for all test classes.
 * Page Objects: Contains page classes representing different pages of the NopCommerce website. Each page class encapsulates the elements and actions on that page.
 * Page User Interface: Contains page UI classes that manage element locators corresponding to each page object.
 * Test Cases: Includes test case classes containing the actual test methods. These test methods utilize page objects to interact with the web elements and perform the test steps.
 * Utilities: Contains utility classes for common functionalities such as reading data from Excel files, logging, and handling browser configurations.
 * Page Factory: A design pattern used to initialize the browser environment.
### 2. Test Data
 * UserData / AdminData: Containing test data in a constant variable form. It included profile data such as name, email, country, city, phone number, etc.
 * Faker library: A Java library to generate fake data for testing.
### 3. XML Configuration Files
* log4j.xml: Configure logging for test classes
* run*.xml: Custom XML file for running test cases.
### 4. Reports
* Allure reports: Provides detailed and visually appealing test reports. Execution results are stored in the 'allure-json' directory.
## How to Run Tests with XML File
1. Clone or download the Selenium Hybrid Framework repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Update the run*.xml file located in the test resources directory with appropriate configuration settings such as browser type, environment, etc.
4. Right-click on the run*.xml file to run it as a TestNG suite.
5. TestNG will execute the test suites defined in the XML file, and the test results will be displayed in the console.
6. After test execution, you can view detailed test reports by navigating to the 'allure-json' directory using the command line and executing the following command:
   
   ```
   allure serve allure-json
   ```
   
# Contributors
* Ly Phi Hoc
* ChatGPT 😉
