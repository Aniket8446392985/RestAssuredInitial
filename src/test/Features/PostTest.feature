Feature:
  Scenario: Hit Post Request
    Given User has base URL
    When User create post request
    Then User hits post request and Status code is 200
