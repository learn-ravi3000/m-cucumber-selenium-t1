# m-cucumber-selenium-test1

Java 21, Selenium, Cucumber, Maven, and TestNG based project to practice web test automation with Chrome.

## Tech Stack

- Java 21
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Selenium Manager (automatic ChromeDriver management)

## Project Structure

```text
src
└── test
	├── java
	│   └── my/examples
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
- Google Chrome 145.x installed
- Local VS Code setup on Windows Home

## Run Tests

Run the Cucumber + TestNG suite:

```powershell
mvn clean test
```

Run in headless mode:

```powershell
mvn clean test -Dheadless=true
```

Run against a custom URL instead of `https://example.com`:

```powershell
mvn clean test -DbaseUrl=https://www.homedepot.com/
```

Use a custom Chrome binary path (if Chrome is installed in a non-default location):

```powershell
mvn clean test "-DchromeBinary=C:\Program Files\Google\Chrome\Application\chrome.exe"
```

## Windows Notes

- Do not set `webdriver.chrome.driver` manually.
- Selenium Manager downloads/uses a compatible ChromeDriver for your installed Chrome version.

## Output

- Console output with scenario steps
- HTML report at `target/cucumber-report.html`
