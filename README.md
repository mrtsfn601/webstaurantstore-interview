# WebstaurantStore Code Screen Task

## Author's Notes

This project demonstrates author's ability n developing a Maven-based test automation mini-framework using Java, Selenium WebDriver, and TestNG. The implementation includes, but is not limited to, the following concepts:

* Java design patterns: Singleton, Builder
* Java object-oriented programming (OOP), inheritance, interface, abstraction, polymorphism
* Selenium Page Object Model, fluent waits and Domain-Specific Language (DSL)

This is not the final version; there are always opportunities for improvement and refactoring. The implementation took two short but joyful evenings, accompanied by coding vibe music and a cup of coffee.

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
