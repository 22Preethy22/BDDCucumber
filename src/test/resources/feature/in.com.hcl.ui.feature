Feature: make my trip functionality browser 
@UItest
Scenario: login functionality
Given launch makemytrip browser
Then login with valid userName as 'name' and password as 'pass'
When I see the 'Name' field