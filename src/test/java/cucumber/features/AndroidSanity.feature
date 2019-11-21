Feature: AndroidSanity

Background: Set the environment
Given User sets the environment


  @reggression @stage @multishard @android
Scenario: DCMEA-0003312 In Person Signing - Sequential Approval EU1 - NA1- JP1
    And Log in with user from "EU1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter in person signer from shard: "NA1"
    And Enter additional recipient from shard: "NA1B"
    And Enter additional recipient from shard: "JP1"
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

    And Log in with user from "AU1" and and delegate to user from "NA1"
    And Log in with user from "NA1" and sign, then log out
    And Log in with user from "EU1" and and delegate to user from "JP1"
    And Log in with user from "JP1" and sign, then log out
    And Log in with user from "NA2B" and and delegate to user from "IN1"
    And Log in with user from "IN1" and sign, then log out

    And Log in with user from "NA2"
    And Click on Completed and verify that the document is in completed folder


@reggression @stage @multishard @android @NA2
Scenario: DCMEA-0003295 4 Shards: NA1 to EU1 to JP1 to AU1 : Send for Signature - Sequential Signing
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


@sanity
Scenario: DCMEA-0003340 Delegate to Approve - Parallel In Person Signing
    And Log in with user from "NA1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter in person signer from shard: "AU1B"
    And Enter additional recipient from shard: "NA1B"
    And Enter additional recipient from shard: "JP1B"
    And Assign delegator to approver role to the recipient from shard: "NA1B"
    And Assign delegator to approver role to the recipient from shard: "JP1B"
    And Click on done on Recipients Page
    And Click on send button on get signature in person

    And Sign the agreement in in person signing flow

    And Click on waiting for others
    And Verify that sign/delegate/approve buttons are not present
    And Click on back button on waiting for others screen
    And Sign out - from home screen

    And Log in with user from "NA1B"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for approval to the recipient from shard: "NA2B"
    And Click on waiting for others
    And Verify that sign/delegate/approve buttons are not present
    And Click on back button on waiting for others screen
    And Sign out - from home screen

    And Log in with user from "JP1B"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for approval to the recipient from shard: "IN1B"
    And Sign out - from home screen

    And Log in with user from "IN1B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "NA2B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen

    And Click on Completed and verify that the document is in completed folder
    And Sign out - from home screen

@sanity
Scenario: DCMEA-0001636 Shard NA1: In Person : Parallel approver
    And Log in with user from "NA1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter in person signer from shard: "AU1B"
    And Assign Approver role to the recipient from shard: "AU1B"
    And Enter additional recipient from shard: "JP1B"
    And Assign Approver role to the recipient from shard: "JP1B"
    And Enter additional recipient from shard: "EU1B"
    And Assign Approver role to the recipient from shard: "EU1B"
    And Enter additional recipient from shard: "IN1B"
    And Assign Approver role to the recipient from shard: "IN1B"
    And Click on Add Me button
    And Assign Approver role to the recipient from shard: "NA1"
    And Click on done on Recipients Page
    And Click on send button on get signature in person
    And Approve the agreement as Sender in parallel approval flow
    And Approve the agreement in in person signing flow
    And Sign out - from home screen

    And Log in with user from "IN1B" and approve, then log out
    And Log in with user from "EU1B" and approve, then log out
    And Log in with user from "JP1B" and approve, then log out

    When User is logged in as sender from shard "NA1"
    Then Agreement should be in completed folder
    @reggression @stage @android
    Scenario: DCMEA-0003304 Delegators Approve & Signer - Sequential In Person Signing + ADD ME (last)
        And Log in with user from "NA1"
        And Click on get signature in person
        And Select document from phone storage
        And Enter agreement name and message
        And Click on recipients button on send page
        And Enter in person signer from shard: "NA12"
        And Enter additional recipient from shard: "NA13"
        And Click on Add Me button
        And Assign delegator to approver role to the recipient from shard: "NA13"
        And Assign delegator to signer role to the recipient from shard: "NA1"
        And Click on done on Recipients Page
        And Click on send button on get signature in person
        And Sign the agreement in in person signing flow
        And Sign out - from home screen

        And Log in with user from "NA13"
        And Click on waiting for you
        And Select agreement you want to delegate and click on it
        And Delegate agreement for approval to the recipient from shard: "NA14"
        And Sign out - from home screen

        And Log in with user from "NA14"
        And Click on waiting for you
        And Select agreement you want to Approve and click on it
        And Click on Approve button on agreements screen
        And Sign out - from home screen

        And Log in with user from "NA1"
        And Click on waiting for you
        And Select agreement you want to delegate and click on it
        And Delegate agreement for signing to the recipient from shard: "NA15"
        And Sign out - from home screen

        And Log in with user from "NA15"
        And Click on waiting for you
        And Select agreement you want to sign and click on it
        And Sign the agreement
        And Click on Completed and verify that the document is in completed folder
       # And Sign out - from home screen


@sanity
Scenario: DCMEA-0000472 Sign Delegators - Parallel Send for Signature
    And Log in with user from "in1b"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter recipient from shard: "in1"
    And Enter recipient from shard: "au1b"
    And Assign delegator to signer role to the recipient from shard: "in1"
    And Assign delegator to signer role to the recipient from shard: "au1b"
    And Click on done on Recipients Page
    And Click on send button
    And Click on waiting for others
    And Verify that sign/delegate/approve buttons are not present
    And Sign out - from home screen

    And Log in with user from "in1"
    And Click on waiting for you
    And Select agreement you want to delegate and click on it
    And Delegate agreement for signing to the recipient from shard: "eu1"
    And Click on waiting for you
    And Verify that document IS under "To Delegate" section
    And Click on waiting for others
    And Verify that document is NOT under "To Sign" section

    And Sign out - from home screen


