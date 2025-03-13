Feature: User Registeration
	I want to check that the user can register in e-commerce website.
	
	Scenario Outline: User Registeration 
	Given the user in the home page 
	When I click on register link 
	And I enter "<firstname>", "<lastname>", "<email>", "<password>"
	Then The registeration page will be dispalyed successfuly
	
	Examples: 
		| firstname | lastname | email | password |
		| Yousef | El-Nabawy | yousef@gmail.com | 12345678 |
		| Ayman | Fathi | ayman@gmail.com | 123456789 |