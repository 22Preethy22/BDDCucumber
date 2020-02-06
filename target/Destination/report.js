$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("in.com.hcl.api.ui.feature");
formatter.feature({
  "line": 1,
  "name": "make my trip functionality browser",
  "description": "",
  "id": "make-my-trip-functionality-browser",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "login functionality",
  "description": "",
  "id": "make-my-trip-functionality-browser;login-functionality",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@test1"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "launch the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "login with valid userName as \u0027name\u0027 and password as \u0027pass\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "I see the \u0027Name\u0027 field",
  "keyword": "When "
});
formatter.match({
  "location": "APIandUITest.launch_the_browser()"
});
formatter.result({
  "duration": 12809041121,
  "status": "passed"
});
formatter.match({
  "location": "APIandUITest.login_with_valid_userName_as_name_and_password_as_pass()"
});
formatter.result({
  "duration": 46080,
  "status": "passed"
});
formatter.match({
  "location": "APIandUITest.i_see_the_Name_field()"
});
formatter.result({
  "duration": 278755,
  "status": "passed"
});
});