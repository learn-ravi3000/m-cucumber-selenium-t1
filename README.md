# m-cucumber-selenium-test1

Java 21, Selenium, Cucumber, Maven, and TestNG based project to practice web test automation with ChromeDriver.

## Tech Stack

- Java 21
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- WebDriverManager (automatic ChromeDriver management)

## Project Structure

```text
src
└── test
	├── java
	│   └── com/example
	│       ├── config
	│       │   └── DriverFactory.java
	│       ├── hooks
	│       │   └── Hooks.java
	│       ├── pages
	│       │   └── ExampleDomainPage.java
	│       ├── runners
	│       │   └── CucumberTestRunner.java
	│       └── steps
	│           └── ExampleDomainSteps.java
	└── resources
		└── features
			└── example-domain.feature
```

## Prerequisites

- Java 21 installed
- Maven 3.9+ installed
- Google Chrome installed

## Run Tests

Run the Cucumber + TestNG suite:

```bash
mvn clean test
```

Run in headless mode:

```bash
mvn clean test -Dheadless=true
```

Run against a custom URL instead of `https://example.com`:

```bash
mvn clean test -DbaseUrl=https://www.homedepot.com/
```

Use a custom Chrome binary path (if Chrome is installed in a non-default location):

```bash
mvn clean test -DchromeBinary=/usr/bin/google-chrome
```

## Output

- Console output with scenario steps
- HTML report at `target/cucumber-report.html`
