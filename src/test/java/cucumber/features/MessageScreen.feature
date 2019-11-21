
Feature: Message Screen functionalities

  Background: Set the environment
    Given User sets the environment

  @sanity
  Scenario: DCMEA-0000460 Message Page - UI
    And Log in with user from "NA1"
    And Click on send for signature
    And Enter agreement name and message
    Then Verify message section

  @sanity @message
  Scenario: DCMEA-0000572 Manually typing in agreement name in the field
    And Log in with user from "NA1B"
    And Click on send for signature
    And Verify message screen place holders
    And Enter agreement name and message
    And Select document from phone storage
    And Click on recipients button on send page
    And Enter recipient from shard: "JP1B"
    Then Verify message section
    And Click on send button
    Then Verify that document is successfully sent