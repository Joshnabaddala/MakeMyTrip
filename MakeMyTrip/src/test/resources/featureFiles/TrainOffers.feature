Feature: TrainOffers

Scenario: Validate that the user is able to navigate to the Train Offers Page

Given Browser should be Launched and URL should be navigated
And Handling Login Pop Up
When user is able to click on Trains link 
And Trains page should be open
When user clicks on View All and Filters Page should be visible
And user clicks on Trains Options 
When user clicks on Trains icon 
Then user should be navigated to the offer page