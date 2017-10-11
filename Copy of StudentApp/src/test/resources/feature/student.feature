Feature: Testing Different requests on the student app

@SMOKE
Scenario: Check if the student app can be accessed by users
When User sends a GET request to the list endpoint, they must get back a valid status code 200

Scenario Outline: Create a new student and verify if the student is added
	
	
	
	
	When I create a new student by providing the information firstName <firstName> lastName <lastName> email <email> programme <programme> courses <courses>
	Then I verify that the student with <email> is created
	 
	Examples:
	| firstName   | lastName | email    | programme | courses |
	| Declon      | Smith    | d@c.com  | CS        | Java    |
	| Michelle    | Symes    | m@s.com  | CS        | REST    |
	
	 