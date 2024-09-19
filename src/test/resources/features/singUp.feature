Feature: Github sign up

  @SignUpOk
  Scenario: Seccessful sign up
    Given the user is on the sing up page of Github
    When the user enters email "tomidiaz227@gmail.com" valid and clicks continue
    And the user enters password "example123" valid and clicks continue
    And the user enters username "UsernameValidTest24" valid and clicks continue
    And the user clicks sign up button

  @SignUpEmailInvalid
  Scenario: Failed sign up with email invalid

  @SignUpPasswordInvalid
  Scenario: Failed sign up with password invalid


  @SignUpUsernameInvalid
  Scenario: Failed sign up with username invalid

