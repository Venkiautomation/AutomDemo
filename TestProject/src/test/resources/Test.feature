Feature: Test sample run

  @Test2
  Scenario: Check if unauthenticated user can click through months of the year
    Given I enter the url and validate page is loaded
    Then I validate page is loaded
    Given I navigate 10 months "behind" of current month
    Then I validate that month has moved "behind" by 10
    And I refresh the page
    Given I navigate 15 months "ahead" of current month
    Then I validate that month has moved "ahead" by 15
    Then I validate main calendar and mini calendar values are same
    And I validate days of month are displayed on calendar
    Given I navigate 1 months "behind" of current month
    And I validate days of month are displayed on calendar
    And I refresh the page
    Given I navigate 1 months "ahead" of current month
    And I validate days of month are displayed on calendar
    And I refresh the page
    Then I validate that today's date is highlighted with blue circle






