# WebstaurantStore Code Screen Task

## Author's Notes

This project demonstrates the author's ability to develop a Maven-based test automation mini-framework using Java, Selenium WebDriver, and TestNG. The implementation includes, but is not limited to, the following concepts:

* Java design patterns: Singleton, Builder
* Java object-oriented programming (OOP), inheritance, interface, abstraction, polymorphism
* Selenium Page Object Model, fluent waits, and Domain-Specific Language (DSL)

This is not the final version; there are always opportunities for improvement and refactoring. The implementation took two short but joyful evenings, accompanied by coding vibe music and a cup of coffee. 🎵☕

Additionally, the below requirement states, _'Check the search result ensuring every product has the word "Table" in its title.'_ However, this is not the case for the item _'metro cr2430dss drive-thru order prep station with stainless steel shelving - 31 3/4" x 27 3/4" x 65 3/4"'_, and the test fails earlier due to an unexpected issue (see the screenshot below). In the code, the author made a tweak to demonstrate that the test is runnable from end to end (see `SearchResultPage#assertItemsOnTheCurrentPageContain`).

<img width="1540" alt="screenshot_rest_failure" src="https://github.com/mrtsfn601/webstaurantstore-interview/assets/80962941/65a46d23-c74b-441f-a6ba-82dbdc1f09b9">


## Task

Create a Maven-based Java or Groovy project and automate the test case described below. Once
complete, upload your code to Github.com.

### Requirements
- [x] Must be runnable on Windows 10
- [x] Written in Java or Groovy, using Selenium
- [x] Chrome browser
  - [x] Use of WebDriverManager highly recommended

### Test case

1. Go to https://www.webstaurantstore.com/
1. Search for "stainless work table".
1. Check the search result ensuring every product has the word "Table" in its title.
1. Add the last of found items to Cart.
1. Empty Cart.

Please add your code to GitHub.com and send the project link.

## Solution

### How to run

#### In IDE

1. Clone the project: `git clone git@github.com:mrtsfn601/webstaurantstore-interview.git`
1. Open the project in IDE of your choice
1. Rebuild the project and load the dependencies if needed
1. Run the `com.webstaurantstore.frontend.DemoTest` java test file

#### In CLI

1. Clone the project: `git clone git@github.com:mrtsfn601/webstaurantstore-interview.git`
1. Go to the project root: `cd webstaurantstore-interview`
1. Run the project: `mvn clean test`
