Feature: Event creation in dairy
  @Test2
  Scenario: Check if authenticated user can create a event with past and future date
    Given I enter the url to the browser
    Then I validate page is loaded
    Then I login using "valid" credentials
    When I create event name with date and month
      | Event Name             | Date | Month   | Label Color | Description         |
      | Venki interview (Done) | 18   | current | green       | Screening Interview |
    Then I validate that event has been created

  @Test3 @sanity
  Scenario: Check if authenticated user can create multiple event with past and future date
    Given I enter the url to the browser
    Then I validate page is loaded
    Then I login using "valid" credentials
    When I create event name with date and month
      | Event Name                          | Date | Month   | Label Color | Description          |
      | Final Interview slot1 1PM-2PM       | 22   | current | red         | Technical Discussion |
      | Final Interview slot2 2.30PM-3.30PM | 23   | current | red         | Technical Discussion |
      | Final Interview slot3 1PM-2PM       | 24   | current | red         | Technical Discussion |
    Then I validate that event has been created
    And I validate the event card is in "red" color

