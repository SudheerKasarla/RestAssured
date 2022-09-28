Feature: Application login



  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login in the login page
		And I should see default Home page
		Then I should see Home page