$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("in.com.hcl.api.feature");
formatter.feature({
  "line": 1,
  "name": "learning rest API thru employee service",
  "description": "",
  "id": "learning-rest-api-thru-employee-service",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "validate POST Request for employee rervice api",
  "description": "",
  "id": "learning-rest-api-thru-employee-service;validate-post-request-for-employee-rervice-api",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@APItest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I get employee api endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Post the request with following",
  "rows": [
    {
      "cells": [
        "emp_name",
        "emp_name"
      ],
      "line": 7
    },
    {
      "cells": [
        "employee_salary",
        "35"
      ],
      "line": 8
    },
    {
      "cells": [
        "employee_age",
        "46"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "validate the response",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 11,
      "value": "#getting the response of posted id"
    }
  ],
  "line": 12,
  "name": "I get Request",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "validate the response",
  "keyword": "Then "
});
formatter.match({
  "location": "APIandUITest.Post_customer_Endpoint()"
});
formatter.result({
  "duration": 930574954,
  "status": "passed"
});
formatter.match({
  "location": "APIandUITest.post_with_following(DataTable)"
});
formatter.result({
  "duration": 4020048036,
  "status": "passed"
});
formatter.match({
  "location": "APIandUITest.validate_response()"
});
formatter.result({
  "duration": 118658198,
  "status": "passed"
});
formatter.match({
  "location": "APIandUITest.sendGetRequest()"
});
formatter.result({
  "duration": 1999984896,
  "status": "passed"
});
formatter.match({
  "location": "APIandUITest.validate_response()"
});
formatter.result({
  "duration": 1778028,
  "error_message": "java.lang.AssertionError: the post was unsuccessful expected:\u003c404\u003e but was:\u003c200\u003e\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:835)\r\n\tat org.junit.Assert.assertEquals(Assert.java:647)\r\n\tat in.com.hcl.stepdefinition.APIandUITest.validate_response(APIandUITest.java:96)\r\n\tat ✽.Then validate the response(in.com.hcl.api.feature:13)\r\n",
  "status": "failed"
});
});