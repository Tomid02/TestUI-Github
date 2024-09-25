Feature: Github sign up

  @SignUpOk
  Scenario: Seccessful sign up
    Given the user is on the sing up page of Github
    When the user enters a valid email "example@gmail.com" and clicks continue
    And the user enters a valid password "example123" and clicks continue
    And the user enters a valid username "UsernameValidTest24" and clicks continue
    And the user clicks sign up button

  @SignUpEmailInvalid
  Scenario: Failed sign up with email invalid

  @SignUpPasswordInvalid
  Scenario: Failed sign up with password invalid


  @SignUpUsernameInvalid
  Scenario: Failed sign up with username invalid

