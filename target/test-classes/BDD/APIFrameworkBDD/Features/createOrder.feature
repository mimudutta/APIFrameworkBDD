Feature: Verify create order API.

Scenario Outline: Verify if order creation is "Successful" with "valid" request parameters
Given Add request payload with valid input "<Name>" "<EmailOrPhone>" "<Amount>"
When User calls "createOrder" API with "POST" https request
Then The API call should be "Success" with response code "200"
And In response body "orderStatus" should be "Created"
And In response body "orderId" displayed "true"

Examples:
	|Name		|EmailOrPhone					|Amount	|
	|NituDidi	|nitukpmgtest1@mailinator.com	|10|
#	|KetanDada	|ketankpmgtest2@mailinator.com	|20|
	
	