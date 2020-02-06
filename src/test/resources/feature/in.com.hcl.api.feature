Feature: learning rest API thru employee service

@APItest
Scenario: validate POST Request for employee rervice api
Given I get employee api endpoint
When Post the request with following 
|emp_name| emp_name|
|employee_salary|35|
|employee_age|46|
Then validate the response
#getting the response of posted id
When I get Request
Then validate the response



@APItest1
Scenario: validate posted employee response
Given I get employee service api endpoint
When I get Request
Then I validated the response



####################################################################################################

 @testRest2
Scenario: validate 2nd employee response
Given I get employee service api endpoint
When I get Request
Then I validated the response
@AP
Scenario: validate POST Request for employee rervice api
Given I get employee service api endpoint
When Post the request with following data
|"id"|"21"|
		|"employee_name"|"Ankita"|
		|"employee_salary"| "400000"|
		|"employee_age"|"16"|
		|profile_image"|""|

Then validate the response