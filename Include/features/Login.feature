@login
Feature: Title of your feature
  I want to use this template for my feature file
  
  @smoke @regression
  Scenario: Sign In successfully
  	Given I navigate to "https://www.oxfordlearnersdictionaries.com/account/login"
  	When I login to system using "phuhnguyen@kms-technology.com" and "Phu31051995" as credentials
  	Then I see an account icon displayed
  	
  @data-driven @regression
	Scenario Outline: Sign in using invalid credentials (<username>\<password>)
		Given I navigate to "https://www.oxfordlearnersdictionaries.com/account/login"
		When I login to system using "<username>" and "<password>" as credentials
		Then I see "<message>" displayed as error message
		
		Examples:
			| username | password | message |
			||| Please enter your username or email address |
			| notemail | moli | The username or password you entered is incorrectt |
	