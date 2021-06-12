Feature: Test Users Stories


  Scenario Outline:
    Given Enter to Carnival
    When  I create a user with a <USERNAME> <PASSWORD> <FIRSTNAME> <LASTNAME> <MONTH_BIRTH> <DAY_BIRTH> <YEAR_BIRTH> <GENDER> <COUNTRY> <PHONE_NUMBER> <WORKING_AGENT> <OFFER> <TERMS_CONDITIONS>
    Then Should be created successfully

    Examples:
      | USERNAME    |  PASSWORD      | FIRSTNAME  |LASTNAME  |MONTH_BIRTH|DAY_BIRTH|YEAR_BIRTH |GENDER |COUNTRY        |PHONE_NUMBER |WORKING_AGENT    |OFFER  |TERMS_CONDITIONS|
      | "userTest"  |  "MyPass321$"  | "john"     |"doe"     |"September"|"1"      |"1990"     |"Male"|"United States"|"6318448715" |"true"           |"true" |"true"         |
