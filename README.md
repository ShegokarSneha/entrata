# Entrata Automation Framework

This project is a **Selenium TestNG automation framework** built using **Java** and **Maven**. It is designed for end-to-end UI automation testing of the Entrata application.

---

## 📁 Project Structure

entrata/
├── src/
│ ├── main/resources/
│ │ └── log4j2.properties
│ ├── test/java/
│ │ ├── com.entrata.configprovider # Configuration handling
│ │ ├── com.entrata.factory # Base step abstractions
│ │ ├── com.entrata.pageobjectmanager # Page object management
│ │ ├── com.entrata.pages # Page Object Model classes
│ │ ├── com.entrata.reports # Extent report utilities
│ │ ├── com.entrata.tests # Test classes
│ │ └── com.entrata.utilities # Helpers like Excel, Logger
│ └── test/resources/
│ ├── data/TestData.xlsx # Test data
│ └── properties/config.properties # Configuration file
├── pom.xml # Maven dependencies and plugins
├── AutomationReports.zip # Archived test reports
└── .gitignore


---

## ⚙️ Tools & Technologies

- **Java 8+**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **ExtentReports** for reporting
- **Log4j2** for logging
- **Excel** for test data
- **Page Object Model (POM)** design pattern

---

## 🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone <repo-url>
   cd entrata

2. **Install dependencies**
   ```bash
   mvn clean install

3. **Run tests**
   ```bash
   mvn test
   
---
**Test Structure**

1. EntrataTests.java contains main test methods.
2. Test data is pulled from TestData.xlsx.
3. Reports are generated via ExtentReports and archived as AutomationReports.zip.

---
**Reports**

1. After test execution, reports are saved in the configured location and optionally zipped (AutomationReports.zip).
2. Detailed test logs and screenshots on failure are also available.

---
**Configuration**

Application and test-specific properties can be configured in:

1. config.properties for environment URLs, credentials, etc.
2. log4j2.properties for logging levels.