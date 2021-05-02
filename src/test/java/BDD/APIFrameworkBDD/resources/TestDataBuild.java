package BDD.APIFrameworkBDD.resources;

import java.util.ArrayList;
import java.util.List;

import BDD.APIFrameworkBDD.pojo.CreateOrders;
import BDD.APIFrameworkBDD.pojo.PayoutDetails;

public class TestDataBuild {

	public CreateOrders createOrderPayload() {          //driving hardcoded data in POJO 
		
		CreateOrders co=new CreateOrders();
		
		co.setCorpId(17829);
		co.setCompanyId(18267);
		co.setProgramId(44623);
		co.setFromDate("2025-11-05");
		co.setToDate("2025-11-05");
		
		List<PayoutDetails> accDetails=new ArrayList<>();    //create list to store Data array 
		
		PayoutDetails mimu=new PayoutDetails();   			//create beneficiery details
		mimu.setName("Mimu");							
		mimu.setEmailOrPhone("mimukpmgtest1@mailinator.com");
		mimu.setAmount("1000");
		
		PayoutDetails pakhi=new PayoutDetails();
		pakhi.setName("Pakhi");								//driving hardcoded data
		pakhi.setEmailOrPhone("mimukpmgtest2@mailinator.com");
		pakhi.setAmount("1000");
		
		PayoutDetails avijit=new PayoutDetails();
		avijit.setName("Avijit");
		avijit.setEmailOrPhone("mimukpmgtest3@mailinator.com");
		avijit.setAmount("1000");
		
		accDetails.add(mimu);								//add beneficiery details to Data array
		accDetails.add(pakhi);
		accDetails.add(avijit);
		
		co.setPayoutDetails(accDetails);					//body parsing complete
		
		return co;
		
	}
	
public CreateOrders createOrderPayload(String name, String emailorphone, String amount) { 	//driving driving data from feature file(Data Driven Testing mechanism)in to POJO
		
		CreateOrders co=new CreateOrders();
		
		co.setCorpId(17829);
		co.setCompanyId(18267);
		co.setProgramId(44623);
		co.setFromDate("2025-11-05");
		co.setToDate("2025-11-05");
		
		List<PayoutDetails> accDetails=new ArrayList<>();    //create list to store Data array 
		
		PayoutDetails mimu=new PayoutDetails();   	//create beneficiery details
		mimu.setName(name);							//driving data from feature file(Data Driven Testing mechanism)
		mimu.setEmailOrPhone(emailorphone);
		mimu.setAmount(amount);
		
		accDetails.add(mimu);						//add beneficiery details to Data array
		
		co.setPayoutDetails(accDetails);			//body parsing complete
		
		return co;
		
	}
}
