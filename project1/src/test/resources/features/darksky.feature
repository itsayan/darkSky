@regression @darksky
Feature: Dark Sky Homepage


Background:
Given I am on DarkSky Homepage

@darkSky-SI1
Scenario: Verify timeline is displayed in correct format
  Then I verify timeline is displayed correctly


@darkSky-SI2
Scenario: Verify individual day temp timeline
  When I expand today's timeline
  Then I verify lowest and highest temp is displayed correctly

@darkSky-SI3
Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
  Then I verify current temp is not greater and less then temps from daily timeline

