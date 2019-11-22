


Feature: Android Sanity 1-10

  Background: Set the environment
    Given User sets the environment

# Add history verification
  @sanity @regression @delegation
  Scenario: DCMEA-0000472 Sign Delegators - Parallel Send for Signature
    And Log in with user from "na1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter recipient from shard: "na12"
    And Enter recipient from shard: "na13"
    And Assign delegator to signer role to the recipient from shard: "na12"
    And Assign delegator to signer role to the recipient from shard: "na13"
    And Click on done on Recipients Page
    And Click on send button
    And Click on waiting for others
    And Verify that sign/delegate/approve buttons are not present
    And Sign out - from home screen

    And Log in with user from "na12"
    And Click on waiting for you
    And Verify that document IS under "To Delegate" section
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for signing to the recipient from shard: "na14"
    And Click on waiting for others
    And Verify that document IS under "To Sign" section
    And Sign out - from home screen

    And Log in with user from "na1"
    And Click on waiting for others
    And Select agreement you want to sign and click on it
    And Sign the agreement in in person signing flow
    And Click on back button on waiting for others screen
    And Sign out - from home screen

    And Log in with user from "na13"
    And Click on waiting for you
    And Verify that document IS under "To Delegate" section
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for signing to the recipient from shard: "na15"
    And Click on waiting for others
    And Verify that document IS under "To Sign" section
    And Sign out - from home screen

    And Log in with user from "na15" and sign, then log out

    When User is logged in as sender from shard "na1"
    Then Agreement should be in completed folder


#2 - Bug DCMEA 3908
  @sanity @regression @delegation
  Scenario: DCMEA-0000399 Sign Delegators - Sequential Send for Sig + ADD ME first
    And Log in with user from "na1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Click on Add Me button
    And Enter recipient from shard: "na12"
    And Assign delegator to signer role to the recipient from shard: "na1"
    And Assign delegator to signer role to the recipient from shard: "na12"
    And Click on done on Recipients Page
    And Click on send button
    And Delegate agreement for signing to the recipient from shard: "na13"
    And Click on waiting for others
    And Verify that document IS under "To Sign" section
    And Click on waiting for others
    And Select agreement you want to sign and click on it
    And Sign the agreement in in person signing flow
    And Click on back button on waiting for others screen
    And Sign out - from home screen

    And Log in with user from "na12"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for approval to the recipient from shard: "NA14"
    And Click on waiting for you
    And Verify that document is NOT in "waiting for you" screen
    And Sign out - from home screen

    And Log in with user from "na1"
    And Click on waiting for others
    And Sign the agreement in in person signing flow

    And Click on Completed and verify that the document is in completed folder






