Feature: Testing the functionality of various widgets

  Scenario: Navigating to the widget page
    Given I open the home page
    When I click the widget card
    Then I am taken to the widget page

  Scenario: Navigating to the slider page
    Given I open the home page
    When I click the widget card
    Then I am taken to the widget page
    When I click the slider button
    Then I am taken to the slider page

  Scenario Outline: Checking the default slider value
    Given I open the slider page
    Then The slider value is "<value>"
    Examples:
      | value |
      | 25    |

  Scenario: Move slider to min and max
    Given I open the slider page
    Then I move the slider to the minimum value
    Then I move the slider to the maximum value

  Scenario Outline: Moving the slider with arrow keys and checking the value is correct
    Given I open the slider page
    When I press the right arrow key <times> times
    Then the slider value should be "<value>"
    Examples:
    |times | value |
    |10     | 60    |
    |20     | 70    |