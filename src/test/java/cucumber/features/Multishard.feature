Feature: SignLogin

  Background: Set the environment
    Given User sets the environment


#1
@regression @stage @multishard
Scenario: DCES-4199633 [Android] Shard EU1: Send for Signature : Parallel Delegate Approval
  And Log in with user from "EU1"
  And Click on send for signature
  And Select document from phone storage
  And Enter agreement name and message
  And Click on recipients button on send page
  And Enter recipient from shard: "NA1"
  And Enter recipient from shard: "EU2"
  And Enter recipient from shard: "IN1"
  And Enter recipient from shard: "JP1"
  And Turn off complete in order listed
  And Assign delegator to approver role to the recipient from shard: "NA1"
  And Assign delegator to approver role to the recipient from shard: "EU2"
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
  And Delegate agreement for approval to the recipient from shard: "NA3"
  And Sign out - from home screen

  And Log in with user from "EU2"
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

  And Log in with user from "NA3"
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


#2
@regression @stage @multishard
Scenario: DCES-4199634 [Android] Shard EU2: Send for Signature : Sequential Delegate Signing
  And Log in with user from "EU2"
  And Click on send for signature
  And Select document from phone storage
  And Enter agreement name and message
  And Click on recipients button on send page
  And Enter recipient from shard: "AU1"
  And Enter recipient from shard: "EU1"
  And Enter recipient from shard: "NA2"
  And Enter recipient from shard: "NA3"
  And Assign delegator to signer role to the recipient from shard: "AU1"
  And Assign delegator to signer role to the recipient from shard: "EU1"
  And Assign delegator to signer role to the recipient from shard: "NA2"
  And Assign delegator to signer role to the recipient from shard: "NA3"
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

  And Log in with user from "NA2"
  And Click on waiting for you
  And Select agreement you want to delegate and click on it
  And Delegate agreement for signing to the recipient from shard: "NA1B"
  And Sign out - from home screen

  And Log in with user from "NA1B"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "NA3"
  And Click on waiting for you
  And Select agreement you want to delegate and click on it
  And Delegate agreement for signing to the recipient from shard: "IN1"
  And Sign out - from home screen

  And Log in with user from "IN1"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "EU2"
  Then Click on Completed and verify that the document is in completed folder


#3
@reggression @stage @multishard
Scenario: DCES-4199635 [Android] Shard IN1: Send for Signature : Parallel signing
  And Log in with user from "IN1"
  And Click on send for signature
  And Select document from phone storage
  And Enter agreement name and message
  And Click on recipients button on send page
  And Turn off complete in order listed
  And Enter recipient from shard: "NA1"
  And Enter recipient from shard: "EU1"
  And Enter recipient from shard: "EU2"
  And Enter recipient from shard: "AU1"
  And Enter recipient from shard: "JP1"
  And Enter recipient from shard: "NA2"
  And Enter recipient from shard: "IN1B"
  And Enter recipient from shard: "NA3"
  And Click on Add Me button
  And Click on done on Recipients Page
  And Click on send button
  And Sign the agreement when agreement automatically loads for signing in paralel workflow
  And Sign out - from home screen

  And Log in with user from "NA1" and sign, then log out
  And Log in with user from "AU1" and sign, then log out
  And Log in with user from "EU2" and sign, then log out
  And Log in with user from "EU1" and sign, then log out
  And Log in with user from "IN1B" and sign, then log out
  And Log in with user from "NA2" and sign, then log out
  And Log in with user from "JP1" and sign, then log out

  And Log in with user from "IN1"
  Then Click on Completed and verify that the document is in completed folder


#4
@reggression @stage @multishard
Scenario: DCES-4199636 [Android] Shard AU1: Send for Signature : Sequential Signing
    And Log in with user from "AU1"
    And Click on send for signature
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter recipient from shard: "NA1"
    And Enter recipient from shard: "EU2"
    And Enter recipient from shard: "EU1"
    And Enter recipient from shard: "AU1B"
    And Enter recipient from shard: "JP1"
    And Enter recipient from shard: "NA2"
    And Enter recipient from shard: "IN1"
    And Enter recipient from shard: "NA3"
    And Click on Add Me button
    And Click on done on Recipients Page
    And Click on send button
    And Sign out - from home screen

    And Log in with user from "NA1" and sign, then log out
    And Log in with user from "EU2" and sign, then log out
    And Log in with user from "EU1" and sign, then log out
    And Log in with user from "AU1B" and sign, then log out
    And Log in with user from "JP1" and sign, then log out
    And Log in with user from "NA2" and sign, then log out
    And Log in with user from "IN1" and sign, then log out
    And Log in with user from "NA3" and sign, then log out
    And Log in with user from "AU1" and sign, then log out
    #log out  and log in with AU1 was performed because it takes server tu update completed section
    And Log in with user from "AU1"
    Then Click on Completed and verify that the document is in completed folder


#5
  @reggression @stage @multishard @NA1
  Scenario:DCES-4199637 [Android] Shard NA1: In person : Parallel approver
    And Log in with user from "NA1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Turn off complete in order listed
    And Enter recipient from shard: "NA1B"
    And Enter recipient from shard: "EU1"
    And Enter recipient from shard: "EU2"
    And Enter recipient from shard: "AU1"
    And Enter recipient from shard: "JP1"
    And Enter recipient from shard: "NA2"
    And Enter recipient from shard: "IN1"
    And Enter recipient from shard: "NA3"
    And Click on Add Me button
    And Click on done on Recipients Page
    And Click on send button on get signature in person

    And Sign the agreement when agreement automatically loads for signing in paralel workflow

    And Sign the agreement in in person signing flow

    And Click on waiting for others
    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"EU1"
    And Sign the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"EU2"
    And Sign the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"AU1"
    And Sign the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"JP1"
    And Sign the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"NA2"
    And Sign the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Select signer on WFO screen in paralel workflow - from shard :"IN1"
    And Sign the agreement in in person signing flow

    And Select agreement you want to sign and click on it
    And Sign the agreement in in person signing flow

    And Click on back button on waiting for others screen
    And Click on Completed and verify that the document is in completed folder

#6
  @reggression @stage @multishard @JP1
  Scenario: DCES-4199638 [Android] Shard JP1: In Person Signing : Sequential Approval
    And Log in with user from "JP1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter in person signer from shard: "NA1"
    And Assign Approver role to the recipient from shard: "NA1"
    And Enter additional signer from shard: "EU1"
    And Assign Approver role to the recipient from shard: "EU1"
    And Enter additional signer from shard: "EU2B"
    And Assign Approver role to the recipient from shard: "EU2B"
    And Enter additional signer from shard: "AU1"
    And Assign Approver role to the recipient from shard: "AU1"
    And Enter additional signer from shard: "JP1B"
    And Assign Approver role to the recipient from shard: "JP1B"
    And Enter additional signer from shard: "NA2"
    And Assign Approver role to the recipient from shard: "NA2"
    And Enter additional signer from shard: "IN1"
    And Assign Approver role to the recipient from shard: "IN1"
    And Enter additional signer from shard: "NA3"
    And Assign Approver role to the recipient from shard: "NA3"
    And Click on Add Me button
    And Assign Approver role to the recipient from shard: "JP1"
    And Click on done on Recipients Page
    And Click on send button on get signature in person
    And Approve the agreement in in person signing flow
    And Sign out - from home screen

    And Log in with user from "EU1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "EU2B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "AU1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "JP1B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "NA2"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "IN1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "NA3"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "JP1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen

    And Click on Completed and verify that the document is in completed folder


#7
  @reggression @stage @multishard @NA3
  Scenario: DCES-4212956 [Android] Shard NA3: Send for Signature : Sequential Signing
  And Log in with user from "NA3"
  And Click on send for signature
  And Select document from phone storage
  And Enter agreement name and message
  And Click on recipients button on send page
  And Enter recipient from shard: "NA1"
  And Enter recipient from shard: "EU1"
  And Enter recipient from shard: "EU2"
  And Enter recipient from shard: "AU1"
  And Enter recipient from shard: "JP1"
  And Enter recipient from shard: "NA2"
  And Enter recipient from shard: "IN1"
  And Enter recipient from shard: "NA3B"
  And Click on Add Me button
  And Click on done on Recipients Page
  And Click on send button
  And Sign out - from home screen

  And Log in with user from "NA1"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "EU1"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "EU2"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "AU1"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "JP1"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "NA2"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "IN1"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "NA3B"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "NA3"
  And Click on waiting for you
  And Select agreement you want to sign and click on it
  And Sign the agreement
  And Sign out - from home screen

  And Log in with user from "NA3"
  Then Click on Completed and verify that the document is in completed folder

#7
  @reggression @stage @multishard @JP1
  Scenario: DCES-4199638 [Android] Shard JP1: In Person Signing : Sequential Approval
    And Log in with user from "JP1"
    And Click on get signature in person
    And Select document from phone storage
    And Enter agreement name and message
    And Click on recipients button on send page
    And Enter in person signer from shard: "NA1"
    And Assign Approver role to the recipient from shard: "NA1"
    And Enter additional signer from shard: "EU1"
    And Assign Approver role to the recipient from shard: "EU1"
    And Enter additional signer from shard: "EU2B"
    And Assign Approver role to the recipient from shard: "EU2B"
    And Enter additional signer from shard: "AU1"
    And Assign Approver role to the recipient from shard: "AU1"
    And Enter additional signer from shard: "JP1B"
    And Assign Approver role to the recipient from shard: "JP1B"
    And Enter additional signer from shard: "NA2"
    And Assign Approver role to the recipient from shard: "NA2"
    And Enter additional signer from shard: "IN1"
    And Assign Approver role to the recipient from shard: "IN1"
    And Enter additional signer from shard: "NA3"
    And Assign Approver role to the recipient from shard: "NA3"
    And Click on Add Me button
    And Assign Approver role to the recipient from shard: "JP1"
    And Click on done on Recipients Page
    And Click on send button on get signature in person
    And Approve the agreement in in person signing flow
    And Sign out - from home screen

    And Log in with user from "EU1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "EU2B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "AU1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "JP1B"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "NA2"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "IN1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "NA3"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen
    And Sign out - from home screen

    And Log in with user from "JP1"
    And Click on waiting for you
    And Select agreement you want to Approve and click on it
    And Click on Approve button on agreements screen

    And Click on Completed and verify that the document is in completed folder


