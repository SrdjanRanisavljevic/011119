

Feature: Sign Basic Test

  Background: Set the environment
    Given User sets the environment

  Scenario: DCMEA-000000 - Login, Send & Sign
    And Log in with user from "EU1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter recipient from shard: "JP1"
    And Click on done on Recipients Page
    And Click on send button
    And Log in with user from "JP1" and sign, then log out
    
    When User is logged in as sender from shard "EU1"
    Then Agreement should be in completed folder

    
    