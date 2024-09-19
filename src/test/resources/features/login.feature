@logingRegresion @testRegresion
Feature: Github Login

  @loginOk
  Scenario: Successful login with valid credentials.
    Given the user is on the login page of Github
    When the user enters username "TestingAutomationUI" and password "TestingUI2024"
    And the user clicks the login button
    Then the user should be logged in

  @loginInvalid
  Scenario: Failed login with valid credentials
    Given the user is on the login page of Github
    When the user enters username "InvalidUsername" and password "InvalidPassword" invalids
    And the user clicks the login button
    Then the user should see an error message "Incorrect username or password."
