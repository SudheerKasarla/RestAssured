Feature:  Validating Place API's

  @AddPlace
  Scenario Outline:  Verify if the Place is being succesfully added using AddPlaceAPI
  Given  Add Place Payload with "<name>" "<language>" "<address>"
  When user calls "AddPlaceAPI" with Post http request
  Then the API call got success with the status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"
  
  Examples:
						| name 			|  language | address |
						|Dalhouse | English    | USA     |    


