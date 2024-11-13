Feature: BookTrainTickets

Scenario: Validate that the user is able to click on Book Train Tickets

Given Browser should be Launched and URL should be navigated
And Handling Login Pop Up
When user is able to click on Trains link
And Trains page should be open 
When user clicks on From dropdown
Then enter city name in From dropdown and select
When user clicks on To dropdown
And enter city name in To dropdown and select
Then user clicks on Travel Date dropdown and select any date
And user clicks on class dropdown and select any class
When user should click on Search button
Then Quick Filters should be displayed






