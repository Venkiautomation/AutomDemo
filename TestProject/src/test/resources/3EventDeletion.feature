Feature: Event deletion from the calendar

  @Test4 @sanity @After
  Scenario Outline: Check if authenticated user can create multiple event with past and future date
    Then I validate page is loaded
    Then I login using "valid" credentials
    And I delete event card with event name "<Event name>"
    Given I validate "<Event name>" is deleted and validate the event count should be <Count>
    Examples:
      | Event name                          | Count |
      | Final Interview slot3 1PM-2PM       | 2     |
      | Final Interview slot2 2.30PM-3.30PM | 1     |