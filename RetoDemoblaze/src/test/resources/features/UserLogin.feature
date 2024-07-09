# language: en

  Feature: Login to Demoblaze
    As a user, I want to log in to the Demoblaze website
    to access my account.
    @ValidationLogin
    Scenario: Successful login with created credentials
      Given the user navigates to the Demoblaze homepage
      When the user clicks on the "Log In" button
      And the user enters the created credentials
      Then the user should be logged in exclusively with the email address used to create the account
       Example:
       | email   |password|
       | prueba09|12345|