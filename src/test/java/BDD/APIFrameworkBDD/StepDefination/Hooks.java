package BDD.APIFrameworkBDD.StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	StepDefination sd=new StepDefination();
	
	@Before("@canclePayout")
	public void beforeScenario() throws Throwable {
		if (StepDefination.actualorderId==0) {
			sd.add_request_payload_with_valid_input_something_something_something("testUser", "testUserVn@mailinator.com", "10");
			sd.user_calls_something_api_with_something_https_request("createOrder", "POST");	
		}	
	}
	
	@After("@createOrder")
	public void afterScenario() throws Throwable {
		if(StepDefination.actualorderId!=0) {
			sd.add_valid_in_resource_parameter(null);
			sd.user_calls_something_api_with_orderid_in_something_https_request("createOrder", "POST");
		}
	}
}
