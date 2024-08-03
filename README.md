# SauceDemo Test Automation Framework

## Overview

The test task involves creating a test automation framework to cover the following UI scenario for test website [Saucedemo](https://www.saucedemo.com/)

1. Login Successful(Standard User)
2. Login Unsuccessful (locked_out_user)
3. Sort Product list (Price low to High, High to Low)
4. Add item to cart
5. Complete checkout and create order

The following technologies are utilized:
- Java
- Selenide
- Maven
- TestNG/JUnit
- Allure

## Project Structure

The project is organized into the following packages:

## Main/base

Contains the `PageBase` class which provides common methods for all page classes.

## Main/pages

Contains the following page classes, each with their properties and methods:

- `CartPage.java`
- `CheckoutPage.java`
- `CompletePage.java`
- `LoginPage.java`
- `OverviewPage.java`
- `ProductsPage.java`

## Test/base

Then I've created the `BaseTest` class in the test package to set up common configurations and to initialize `baseUrl` there.

## Test/tests

Divided into three test classes to handle different test scenarios:

- `CartAndCheckoutTest.java`
- `LoginTest.java`
- `ProductSortingTest.java`

#
