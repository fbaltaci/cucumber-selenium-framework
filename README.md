# Cucumber + Selenium Java UI Automation Framework

This is a simple yet scalable UI automation framework built using **Cucumber (BDD)**, **Selenium WebDriver**, and **TestNG** in **Java**. It follows best practices like Page Object Model (POM), browser parameterization, and reusable step definitions.

**Badges:**

* Framework: Cucumber + Selenium
* Language: Java 17
* Build: Maven

---

## Features

* BDD-style test writing using **Cucumber**
* UI automation with **Selenium WebDriver**
* **Page Object Model** design pattern
* **Cross-browser support** (Chrome, Firefox)
* Test execution via **TestNG**
* HTML reporting with built-in **Cucumber reports**
* CI/CD ready with **GitHub Actions**
* Uses **WebDriverManager** for auto-driver setup

---

## Project Structure
```
cucumber-selenium-framework/
├── src/
│   ├── main/java/utils/             # Driver setup
│   └── test/
│       ├── java/pages/             # Page Object Model classes
│       ├── java/stepdefinitions/   # Step definitions for feature files
│       ├── java/runners/           # TestNG runner class
│       └── resources/features/     # Cucumber .feature files
├── testng.xml                       # TestNG configuration for browser params
├── pom.xml                          # Maven dependencies
```
---

## Getting Started

### 1. Clone the project

```shell

git clone [https://github.com/your-username/cucumber-selenium-framework.git](https://github.com/your-username/cucumber-selenium-framework.git)
cd cucumber-selenium-framework
```

### 2. Install dependencies

```shell

mvn clean install
```

### 3. Run the tests

```shell

mvn test
```

Or, using `testng.xml` for browser control:

mvn test -DsuiteXmlFile=testng.xml

---

## Supported Browsers

* Chrome (default)
* Firefox (via `testng.xml` parameter)

You can add more browsers in `DriverFactory.java`.

---

## Sample Test Scenario

```gherkin
Feature: Add to cart functionality
Scenario: Add one product to cart
Given I am on the SauceDemo login page
When I enter username "standard\_user" and password "secret\_sauce"
And I click on the login button
And I add the product "Sauce Labs Backpack" to the cart
Then the cart badge should show "1"
```

---

## Reporting

After each test run, a basic **HTML report** is generated at:

target/cucumber-report.html

Open it in a browser to view results.

---

## CI/CD Integration

This project includes a basic GitHub Actions workflow file to run tests on every push or pull request:

.github/workflows/ui-tests.yml

---

## Tech Stack

* Java 17
* Maven
* Selenium WebDriver
* Cucumber (Gherkin)
* TestNG
* WebDriverManager
* GitHub Actions (CI)

---

## Author

**Fehmi Baltacı**
GitHub: [https://github.com/fbaltaci](https://github.com/fbaltaci)
LinkedIn: [https://www.linkedin.com/in/fehmi-baltaci](https://www.linkedin.com/in/fehmi-baltaci)

---

## License

This project is open-source and available under the MIT License.