Feature: Application login

  Scenario: Validate login functionality of OrangeHCm
    Given I launch the OrangeHCM application
    When I enter Username as "Admin"
    And I enter password as "Admin123"
    And I click on sigin button
    Then I should see HomePage of OrangeHCM
