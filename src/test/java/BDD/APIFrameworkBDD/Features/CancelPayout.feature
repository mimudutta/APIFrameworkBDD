@canclePayout @Regression
Feature: Cancle Payout API for KPMG.

Scenario: Verify if order deletion is Successful
Given Add valid "orderId" in resource parameter
When User calls "cancelOrder" API with orderId in "POST" https request
Then The API call should be "Success" with response code "200"
And In response body "status" to be "Cancelled"