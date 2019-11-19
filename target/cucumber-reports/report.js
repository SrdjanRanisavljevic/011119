$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/cucumber/features/SignBasicTest.feature");
formatter.feature({
  "line": 3,
  "name": "Sign Basic Test",
  "description": "",
  "id": "sign-basic-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 270200,
  "status": "passed"
});
formatter.before({
  "duration": 45200,
  "status": "passed"
});
formatter.before({
  "duration": 50518219100,
  "status": "passed"
});
formatter.before({
  "duration": 5448105600,
  "status": "passed"
});
formatter.before({
  "duration": 36800,
  "status": "passed"
});
formatter.before({
  "duration": 5048100,
  "status": "passed"
});
formatter.before({
  "duration": 2482200,
  "status": "passed"
});
formatter.before({
  "duration": 257282900,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "Set the environment",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "User sets the environment",
  "keyword": "Given "
});
formatter.match({
  "location": "SignStepDefinitions.setServer()"
});
formatter.result({
  "duration": 12708922200,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "DCMEA-000000 - Login, Send \u0026 Sign",
  "description": "",
  "id": "sign-basic-test;dcmea-000000---login,-send-\u0026-sign",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "Log in with user from \"EU1\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Click on send for signature",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Select document from phone storage",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter agreement name and message",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Click on recipients button on send page",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Enter recipient from shard: \"JP1\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Click on done on Recipients Page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Click on send button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Log in with user from \"JP1\" and sign, then log out",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User is logged in as sender from shard \"EU1\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Agreement should be in completed folder",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "EU1",
      "offset": 23
    }
  ],
  "location": "SignStepDefinitions.logIn(String)"
});
formatter.result({
  "duration": 5600490300,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.clickOnSendForSignature()"
});
formatter.result({
  "duration": 19942408200,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.userSelectDocument()"
});
formatter.result({
  "duration": 24929782200,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.userEntersAgrementNameAndMessage()"
});
formatter.result({
  "duration": 10806320500,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.clickOnRecipientsButtonOnSednPage()"
});
formatter.result({
  "duration": 2013170500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "JP1",
      "offset": 29
    }
  ],
  "location": "SignStepDefinitions.enterRecipientFromShared(String)"
});
formatter.result({
  "duration": 2420059500,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.clickDoneOnRecipientsPage()"
});
formatter.result({
  "duration": 2113511400,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.userClicksOnSendButton()"
});
formatter.result({
  "duration": 1630936200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "JP1",
      "offset": 23
    }
  ],
  "location": "SignStepDefinitions.logInAndSign(String)"
});
formatter.result({
  "duration": 167521535000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EU1",
      "offset": 40
    }
  ],
  "location": "SignStepDefinitions.logInToCheckComplete(String)"
});
formatter.result({
  "duration": 9172013100,
  "status": "passed"
});
formatter.match({
  "location": "SignStepDefinitions.thenAgreementIsInCompletedFolder()"
});
formatter.result({
  "duration": 29131651700,
  "status": "passed"
});
formatter.after({
  "duration": 4279102400,
  "status": "passed"
});
formatter.after({
  "duration": 40200,
  "status": "passed"
});
});