Feature: AndroidSanity

#Background:
#Given User is in Launcher Screen


  @reggression @stage @multishard @android
Scenario: DCMEA-0003312 In Person Signing - Sequential Approval EU1 - NA1- JP1
    Given The environment is set to: "stage"
    And Log in with user from "EU1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter in person signer from shard: "NA1"
    And Enter additional signer from shard: "NA1B"
    And Enter additional signer from shard: "JP1"
    And Assign Approver role to the recipient from shard: "NA1"
    And Assign Approver role to the recipient from shard: "NA1B"
    And Assign Approver role to the recipient from shard: "JP1"
    And Click on done on Recipients Page
    And Click on send button on get signature in person
    And Approve the agreement in in person signing flow

    And Click on waiting for others
    And Select agreement you want to sign and click on it
    And Approve the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Approve the agreement in in person signing flow

    Then Click on Completed and verify that the document is in completed folder


  @reggression @stage @multishard @android @EU1
Scenario: DCMEA-0001600 [Android] Shard EU1: Send for Signature : Parallel Delegate Approval
    Given The environment is set to: "stage"
    And Log in with user from "EU1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter recipient from shard: "NA1"
    And Enter recipient from shard: "IN1"
    And Enter recipient from shard: "JP1"
    And Assign delegator to approver role to the recipient from shard: "NA1"
    And Assign delegator to approver role to the recipient from shard: "IN1"
    And Assign delegator to approver role to the recipient from shard: "JP1"
    And Click on done on Recipients Page
    And Click on send button
    And Sign out - from home screen

    And Log in with user from "JP1"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for approval to the recipient from shard: "NA2"
    And Sign out - from home screen

    And Log in with user from "NA1"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for approval to the recipient from shard: "AU1"
    And Sign out - from home screen

    And Log in with user from "IN1"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for approval to the recipient from shard: "EU1B"
    And Sign out - from home screen

    And Log in with user from "NA2"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "AU1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "EU1B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "EU1"
    Then Click on Completed and verify that the document is in completed folder

  @reggression @stage @multishard @android @EU1
Scenario: DCMEA-0003175 3+ Shards(Home Shard to Shard A, Shard B and Add Me) : Send for Signature - Parallel Signing
    Given The environment is set to: "stage"
    And Log in with user from "NA1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter recipient from shard: "NA2"
    And Enter recipient from shard: "NA3"
    And Click on Add Me button
    And Click on done on Recipients Page
    And Click on send button
    And Sign the agreement when agreement automatically loads for signing in paralel workflow
    And Sign out - from home screen

    And Log in with user from "NA3"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement
    And Sign out - from home screen

    And Log in with user from "NA2"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement

    And Click on Completed and verify that the document is in completed folder


  @reggression @stage @multishard @android @NA2
Scenario: DCMEA-0001599 Shard NA2: Send for Signature : Sequential Delegate signing
    Given The environment is set to: "stage"
    And Log in with user from "NA2"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter recipient from shard: "AU1"
    And Enter recipient from shard: "EU1"
    And Enter recipient from shard: "NA2"
    And Assign delegator to signer role to the recipient from shard: "AU1"
    And Assign delegator to signer role to the recipient from shard: "EU1"
    And Assign delegator to signer role to the recipient from shard: "NA2B"
    And Click on done on Recipients Page
    And Click on send button
    And Sign out - from home screen

    And Log in with user from "AU1"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for signing to the recipient from shard: "NA1"
    And Sign out - from home screen

    And Log in with user from "NA1"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement
    And Sign out - from home screen

    And Log in with user from "EU1"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for signing to the recipient from shard: "JP1"
    And Sign out - from home screen

    And Log in with user from "JP1"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement
    And Sign out - from home screen

    And Log in with user from "NA2B"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for signing to the recipient from shard: "IN1"
    And Sign out - from home screen

    And Log in with user from "NA2"
    And Click on Completed and verify that the document is in completed folder


    @reggression @stage @multishard @android @NA2
Scenario: DCMEA-0003295 4 Shards: NA1 to EU1 to JP1 to AU1 : Send for Signature - Sequential Signing
    Given The environment is set to: "stage"
    And Log in with user from "NA1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter recipient from shard: "NA2"
    And Enter recipient from shard: "NA3"
    And Enter recipient from shard: "EU1"
    And Click on done on Recipients Page
    And Click on send button
    And Sign out - from home screen

    And Log in with user from "NA2"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement
    And Sign out - from home screen

    And Log in with user from "NA3"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement
    And Sign out - from home screen

    And Log in with user from "EU1"
    And Click on waiting for you
    And Select agreement you want to sign and click on it
    And Sign the agreement
    And Sign out - from home screen

    And Log in with user from "NA1"
    And Click on Completed and verify that the document is in completed folder


Scenario: DCMEA-0000466 Send for Signature - Parallel Approval workflow
    Given The environment is set to: "stage"
    And Log in with user from "NA1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter recipient from shard: "NA1B"
    And Enter recipient from shard: "NA2B"
    And Enter recipient from shard: "EU2B"
    And Assign Approver role to the recipient from shard: "NA1B"
    And Assign Approver role to the recipient from shard: "NA2B"
    And Assign Approver role to the recipient from shard: "EU2B"
    And Click on done on Recipients Page
    And Click on send button
    And Click on waiting for others

    And Select agreement you want to Approve and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"NA1B"
    And Approve the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"NA2B"
    And Approve the agreement in in person signing flow

    #When there is last signer / approver left, you do not have to choose it from the list
    And Select agreement you want to sign and click on it
    And Approve the agreement in in person signing flow

    And Click on Completed and verify that the document is in completed folder


