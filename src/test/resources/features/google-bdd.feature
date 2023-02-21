Feature: testing stuff with BDD

  Scenario: Generate a random Person and google him or her with Data Holder
    Given I generate a random "person_1"
    Given I save person "person_1" to DB

#    And I load google page
#    When I google for person "person_1"
#    Then I can see "person_1" name in search results

#  Scenario: Generate a random Person and google him or her with Data Holder
#    Given I generate a random "person_1"
#    Given I generate a random "person_2"
#    Given I generate a random "person_3"
#    And I load google page
#    When I google for person "person_1"
#    Then I can see "person_1" name in search results
#    And I load google page
#    When I google for person "person_2"
#    Then I can see "person_2" name in search results
#    And I load google page
#    When I google for person "person_3"
#    Then I can see "person_3" name in search results

#  Scenario: BDD params showcase
#    Given Print message "test message"
#    Given Multiple params "parameter" go like this "another one"
#    Given Int params 9999!
#
#  Scenario: Enum casting showcase
#    Given I generate a random "person_1"
#    And I load google page
#    When I set SEARCH value to name of "person_1"
#    When I send key ENTER to SEARCH
#    Then I see "person_1" name in SEARCH_HEADERS