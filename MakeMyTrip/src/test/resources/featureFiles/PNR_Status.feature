Feature: Check PNR Status

Scenario Outline: Validate when user enters their phone number in Check PNR Status without booking 
 the ticket then should throw message like This PNR is either not generated or flushed

Given Browser should be Launched and URL should be navigated
And Handling Login Pop Up
When user is able to click on Trains link
And Trains page should be open 
When user clicks on Check PNR Status 
Then input field should display
When user enters their <phone number> in input feild
And click on Check Status
Then it should navigate to the PNR Status Page 
And user should see the message like This PNR is either not generated or flushed

Examples:
  | phone number |
  |  1  |
  |  2  |
  |  3  |
  