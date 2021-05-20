package BDD.APIFrameworkBDD.StepDefination;

import static io.restassured.RestAssured.given;


import org.junit.runner.RunWith;

import BDD.APIFrameworkBDD.pojo.CreateOrders;
import BDD.APIFrameworkBDD.pojo.PayoutDetails;
import BDD.APIFrameworkBDD.resources.APIResources;
import BDD.APIFrameworkBDD.resources.TestDataBuild;
import BDD.APIFrameworkBDD.resources.Utils;
import BDD.APIFrameworkBDD.pojo.CreateOrdersResp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;

import java.io.IOException;

@RunWith(Cucumber.class)
public class StepDefination extends Utils{

	RequestSpecification req;
	Response resp;

	CreateOrdersResp CreateOrdersResp;
	TestDataBuild data=new TestDataBuild();
	APIResources resourceAPI;
	public static int actualorderId;
	public static int payoutsize;
	public static String actualOrderStatVal;
	
	

	@Given("^Add request payload with valid input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_request_payload_with_valid_input_something_something_something(String name, String emailorphone, String amount) throws Throwable {
		
		req = given().log().all().spec(requestSpecification()).body(data.createOrderPayload(name,emailorphone,amount));
		
    }

	@When("^User calls \"([^\"]*)\" API with \"([^\"]*)\" https request$")
    public void user_calls_something_api_with_something_https_request(String resource, String method) throws Throwable {
		
		resourceAPI = APIResources.valueOf(resource);	//constructor of enum will be called with value of resource which you pass
		//resourceAPI.getResource();
		
		if(method.equalsIgnoreCase("POST")) {
			resp = req.when().post(resourceAPI.getResource()).then().log().all().
					spec(responseSpecification()).extract().response();
		}
		else {
			System.out.println("Not correct Method");
		}	
		
		CreateOrdersResp=resp.as(CreateOrdersResp.class);
		payoutsize=CreateOrdersResp.getOrders().size();
		actualOrderStatVal = null;
		
		for(int i=0; i<payoutsize; i++) {									//assertion using getter in POJO
			System.out.println("Order_ID:"+CreateOrdersResp.getOrders().get(i).getOrderId());
			
			actualorderId=CreateOrdersResp.getOrders().get(i).getOrderId();
			//assertTrue(actualorderId % 1 == 0);
			
			actualOrderStatVal=CreateOrdersResp.getOrders().get(i).getOrderStatus();
			CreateOrdersResp.getOrders().get(i).getScheduledDate();
			for(int j=0; j<CreateOrdersResp.getOrders().get(i).getPayoutDetails().size(); j++) {
				//CreateOrdersResp.getOrders().get(i).getPayoutDetails().size();
				int pauoutID = CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getId();
				String name =CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getName();
				String userVector = CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getEmailOrPhone();
				int amount=CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getAmount();
				
				System.out.println("payoutID:"+pauoutID);
				System.out.println("name:"+name);
				System.out.println("userVector:"+userVector);
				System.out.println("amount:"+amount);
			}
		}
    }

    @Then("^The API call should be \"([^\"]*)\" with response code \"([^\"]*)\"$")
    public void the_api_call_should_be_something_with_response_code_something(String status, int statusCode) throws Throwable {
    	
    	assertEquals(resp.getStatusCode(),statusCode);

    }

    @And("^In response body \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void in_response_body_orderStatus_should_be_something_orderStatus(String key, String Expvalue) throws Throwable {
    	
		/*
		 * CreateOrdersResp=resp.as(CreateOrdersResp.class); int
		 * payoutsize=CreateOrdersResp.getOrders().size(); String actualOrderStatVal =
		 * null;
		 */
		
		assertEquals(getJsonPath(resp, "orders[0]."+key), Expvalue); 		//assertion using JsonPath
		
		
		/*
		 * for(int i=0; i<payoutsize; i++) { //assertion using getter in POJO
		 * System.out.println("Order_ID:"+CreateOrdersResp.getOrders().get(i).getOrderId
		 * ());
		 * 
		 * actualorderId=CreateOrdersResp.getOrders().get(i).getOrderId();
		 * assertTrue(actualorderId % 1 == 0);
		 * 
		 * actualOrderStatVal=CreateOrdersResp.getOrders().get(i).getOrderStatus();
		 * CreateOrdersResp.getOrders().get(i).getScheduledDate(); for(int j=0;
		 * j<CreateOrdersResp.getOrders().get(i).getPayoutDetails().size(); j++) {
		 * //CreateOrdersResp.getOrders().get(i).getPayoutDetails().size(); int pauoutID
		 * = CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getId();
		 * String name
		 * =CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getName();
		 * String userVector =
		 * CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).getEmailOrPhone
		 * (); int amount=CreateOrdersResp.getOrders().get(i).getPayoutDetails().get(j).
		 * getAmount();
		 * 
		 * System.out.println("payoutID:"+pauoutID); System.out.println("name:"+name);
		 * System.out.println("userVector:"+userVector);
		 * System.out.println("amount:"+amount); } }
		 */
		
		assertEquals(actualOrderStatVal,Expvalue);			//assertion using getter in POJO
    }
    
    @And("^In response body \"([^\"]*)\" displayed \"([^\"]*)\"$")
    public void in_response_body_something_displayed_something(String key, Boolean flag) throws Throwable {
    	
    	if(actualorderId % 1 == 0) {
    		assertTrue(flag);
    	}
    	else {
			System.out.println(key+" is invalid");
			assertFalse(flag);
		}		
	}
    
   @Given("Add valid {string} in resource parameter")
    public void add_valid_in_resource_parameter(String string) throws IOException {
    	req = given().log().all().spec(requestSpecification());
    	
    }
    
   @When("^User calls \"([^\"]*)\" API with orderId in \"([^\"]*)\" https request$")
    public void user_calls_something_api_with_orderid_in_something_https_request(String resource, String method) throws Throwable {
    	//resp = req.when().post("/sodexo/orders/"+Integer.toString(actualorderId)+"/cancel").then().log().all().
				//spec(responseSpecification()).extract().response();
    	resourceAPI = APIResources.valueOf(resource);	//constructor of enum will be called with value of resource which you pass
		//resourceAPI.getResource();
		
		if(method.equalsIgnoreCase("POST")) {
			resp = req.when().post(resourceAPI.getResource()+"/"+getorderId()+"/cancel").then().log().all().
					spec(responseSpecification()).extract().response();
		}
		else {
			System.out.println("Not correct Method");
		}
    }
    
   @And("^In response body \"([^\"]*)\" to be \"([^\"]*)\"$")
    public void in_response_body_something_to_be_something(String key, String Expvalue) throws Throwable {
    	assertEquals(getJsonPath(resp, key), Expvalue); 
    }

    
    public String getorderId() {
    	System.out.println("actualorderId in getorderId method:"+actualorderId);
		return Integer.toString(actualorderId);
    	
    }

}
