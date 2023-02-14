Feature: testing stuff with BDD

  Scenario: Generate a random Person and google him or her
    Given I generate a random Person
    And I load google page
    When I google for random Person
    Then I can see random Persons name in search results

  Scenario: BDD params showcase
    Given Print message "test message"
    Given Multiple params "parameter" go like this "another one"
    Given Int params 9999!