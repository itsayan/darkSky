$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky.feature");
formatter.feature({
  "line": 2,
  "name": "Dark Sky Homepage",
  "description": "",
  "id": "dark-sky-homepage",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@darksky"
    }
  ]
});
formatter.before({
  "duration": 5606847996,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on DarkSky Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnHomepageOfDarkSky()"
});
formatter.result({
  "duration": 552036109,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify timeline is displayed in correct format",
  "description": "",
  "id": "dark-sky-homepage;verify-timeline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@darkSky-SI1"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I verify timeline is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "timeline",
      "offset": 9
    }
  ],
  "location": "DarkSkySD.verifyCorrectDisplay(String)"
});
formatter.result({
  "duration": 10299923,
  "status": "passed"
});
formatter.after({
  "duration": 152238133,
  "status": "passed"
});
formatter.before({
  "duration": 3363598969,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on DarkSky Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnHomepageOfDarkSky()"
});
formatter.result({
  "duration": 15605786,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "dark-sky-homepage;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@darkSky-SI2"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "I expand today\u0027s timeline",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.clickOnTodaysBar()"
});
formatter.result({
  "duration": 5647174048,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lowest and highest temp",
      "offset": 9
    }
  ],
  "location": "DarkSkySD.verifyCorrectDisplay(String)"
});
formatter.result({
  "duration": 105928,
  "status": "passed"
});
formatter.after({
  "duration": 144549272,
  "status": "passed"
});
formatter.before({
  "duration": 2984636706,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on DarkSky Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnHomepageOfDarkSky()"
});
formatter.result({
  "duration": 16068439,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline",
  "description": "",
  "id": "dark-sky-homepage;verify-current-temperature-should-not-be-greater-or-less-than-the-temperature-from-daily-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@darkSky-SI3"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "I verify current temp is not greater and less then temps from daily timeline",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.verifyTemp()"
});
formatter.result({
  "duration": 491800812,
  "status": "passed"
});
formatter.after({
  "duration": 134828781,
  "status": "passed"
});
});