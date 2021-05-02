package BDD.APIFrameworkBDD.StepDefination;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

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

@RunWith(Cucumber.class)
public class StepDefinationCreateOrder extends Utils{

	public static RequestSpecification req;
	public static Response resp;

	public static CreateOrdersResp CreateOrdersResp;
	public static TestDataBuild data=new TestDataBuild();
	public static APIResources resourceAPI;
	public static int actualorderId;
	
	//int statusCode=200;
	//String Expvalue="Created";
	

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
    }

    @Then("^The API call should be \"([^\"]*)\" with response code \"([^\"]*)\"$")
    public void the_api_call_should_be_something_with_response_code_something(String status, int statusCode) throws Throwable {
    	
    	assertEquals(resp.getStatusCode(),statusCode);

    }

    @And("^In response body \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void in_response_body_orderStatus_should_be_Created_orderStatus(String key, String Expvalue) throws Throwable {
    	
    	CreateOrdersResp=resp.as(CreateOrdersResp.class);
		int payoutsize=CreateOrdersResp.getOrders().size();
		String actualOrderStatVal = null;
		
		assertEquals(getJsonPath(resp, "orders[0]."+key), Expvalue); 		//assertion using JsonPath
		
		
		for(int i=0; i<payoutsize; i++) {									//assertion using getter in POJO
			System.out.println("Order_ID:"+CreateOrdersResp.getOrders().get(i).getOrderId());
			
			actualorderId=CreateOrdersResp.getOrders().get(i).getOrderId();
			assertTrue(actualorderId % 1 == 0);
			
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
		
		assertEquals(actualOrderStatVal,Expvalue);			//assertion using getter in POJO
    }
    
    @And("^In response body \"([^\"]*)\" displayed \"([^\"]*)\"$")
    public void in_response_body_something_displayed_something(String key, Boolean flag) throws Throwable {
    	
    	if(actualorderId % 1 == 1) {
    		assertTrue(flag);
    	}
    	else {
			System.out.println(key+" is invalid");
		}
	   
		
	}

}
