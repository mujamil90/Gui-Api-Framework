# GUI - API Automation Framework

[![N|Solid](http://www.seleniumhq.org/images/selenium-logo.png)](http://www.seleniumhq.org/)
[![N|Solid](https://rest-assured.io/img/logo-transparent.png)

**This is a Selenium DataDriven Framework. Now no worry about to download and keep browser binary driver (geckoDriver.exe and chromedriver) on class-path as it will take care by **webdrivermanager** so no worry about compatibility issues between selenium and browser compatibility. You have to just keep selenium dependency  and browser on latest version.**


- Designed and written in **JAVA**
- Implemented using **TestNG**
- Build Tools - **Maven**
- Test data source file type- **JSON files** 
- Implemented with  **Page Object Model Design Pattern with Page Factory**
- Builder pattern for API tests
- Sample Pipeline is implemented

### Browsers Supported
- Mozilla Firefox
- Google Chrome
- Internet Explorer

### Platform Support
- Windows
- Linux
- Macintosh

---
### Reporting
- [Extent Reporting](http://extentreports.com/)

---
### Usage
```sh
$ mvn clean test
```
```sh
mvn clean test -Dsurefire.suiteXmlFiles=GUI-Tests.xml
```
---
### Browser Setup
- Navigate to *.\src\main\resources* change *BrowserType* in the Config.properties
---

### Report Details

**Report Location** `System.getProperty("user.dir") + "/src/test/resources/Reports/";`

**Failed Screenshots** `System.getProperty("user.dir") + "/src/test/resources/Reports/Images";`

**Video Location** `System.getProperty("user.dir") + "videos";`

**Test Data** `System.getProperty("user.dir") + "/src/test/resources/TestData";`

---


