$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('org\ECSDigital\testcases\TestValidation.feature');
formatter.feature({
  "line": 1,
  "name": "ECSDigital Assignment",
  "description": "",
  "id": "ecsdigital-assignment",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Find the index of Arrays",
  "description": "",
  "id": "ecsdigital-assignment;find-the-index-of-arrays",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "User is on ECSDigital Test page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "User clicks on Render the Challenge button",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "User reads the table and find the index of each row",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "User submit the answers",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.User_is_on_ECSDigital_Test_page()"
});
formatter.result({
  "duration": 13718321000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.User_clicks_on_Render_the_Challenge_button()"
});
formatter.result({
  "duration": 585936317,
  "status": "passed"
});
formatter.match({
  "location": "Steps.User_reads_the_table_and_find_the_index_of_each_row()"
});
formatter.result({
  "duration": 1770038054,
  "status": "passed"
});
formatter.match({
  "location": "Steps.User_submit_the_answers()"
});
formatter.result({
  "duration": 713823513,
  "status": "passed"
});
});