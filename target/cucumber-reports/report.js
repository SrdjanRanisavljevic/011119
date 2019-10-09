$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/cucumber/features/SignLogin.feature");
formatter.feature({
  "line": 1,
  "name": "SignLogin",
  "description": "",
  "id": "signlogin",
  "keyword": "Feature"
});
formatter.before({
  "duration": 83525400,
  "status": "passed"
});
formatter.before({
  "duration": 79500,
  "status": "passed"
});
formatter.before({
  "duration": 32200472700,
  "status": "passed"
});
formatter.before({
  "duration": 2538823100,
  "status": "passed"
});
formatter.before({
  "duration": 35400,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#Background:"
    },
    {
      "line": 4,
      "value": "#Given User is in Launcher Screen"
    }
  ],
  "line": 7,
  "name": "Sign Login Feature",
  "description": "",
  "id": "signlogin;sign-login-feature",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Sign in with production user and change server to Stage",
  "keyword": "Given "
});
formatter.match({
  "location": "SignStepDefinitions.changeServerToStage()"
});
formatter.result({
  "duration": 43717732100,
  "error_message": "java.lang.AssertionError: Cannot click on Login button from Sign Launcher screen\r\n\tat api.sign.launcher.SignLauncherView.clickOnLoginButton(SignLauncherView.java:93)\r\n\tat cucumber.cucumberTests.SignStepDefinitions.changeServerToStage(SignStepDefinitions.java:296)\r\n\tat ✽.Given Sign in with production user and change server to Stage(src/test/java/cucumber/features/SignLogin.feature:8)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4572102700,
  "status": "passed"
});
formatter.after({
  "duration": 31300,
  "status": "passed"
});
});