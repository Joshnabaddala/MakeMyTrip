Feature: LiveTrainStatus


Scenario: Validate that the user is able to click on Live Train Status

Given Browser should be Launched and URL should be navigated
And Handling Login Pop Up
When user is able to click on Trains link
And Trains page should be open
Then user should click on Live Train Status
When user clicks on TrainNumberOrName 
Then user enters Train Number in TrainNumberOrName dropdown and select
And user clicks on Your Stop dropdown and select any Stop
When user clicks on Train Start Date and select any date
Then click on Check Status button
And user Train Number should be displayed