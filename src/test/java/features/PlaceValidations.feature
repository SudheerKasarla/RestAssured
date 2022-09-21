Feature:  Validating Place API's

  @positive
  Scenario:  Verify if the Place is being succesfully added using AddPlaceAPI
  Given  Add Place Payload
  When user calls "AddPlaceAPI" with Post http request
  Then the API call got success with the status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"
    

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
