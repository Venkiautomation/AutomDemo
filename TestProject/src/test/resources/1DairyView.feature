Feature: Dairy View of the calendar

  @Test1
  Scenario: Check if unauthenticated user can click through months of the year
    Given I enter the url to the browser
    Then I validate page is loaded
    Given I navigate 12 months "behind" of current month and validate days of all month can be seen
    Then I validate that month has moved "behind" by 12
    Then I validate main calendar and mini calendar values are same
    And I refresh the page
    Given I navigate 12 months "ahead" of current month and validate days of all month can be seen
    Then I validate that month has moved "ahead" by 12
    Then I validate main calendar and mini calendar values are same
    Given I navigate 1 months "behind" of current month and validate days of all month can be seen
    And I refresh the page
    Given I navigate 1 months "ahead" of current month and validate days of all month can be seen
    And I refresh the page
    Then I validate that today's date is highlighted with blue circle








