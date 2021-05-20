package BDD.APIFrameworkBDD.resources;


public enum APIResources {
	
	
	createOrder("/sodexo/orders"),
	cancelOrder("/sodexo/orders"),
	cancelPayout("/sodexo/orders/102473/payouts/cancel");
	
	private String resource;
	
	
	APIResources(String resource) {
		//System.out.println(StepDefinationCreateOrder.actualorderId);
		this.resource=resource;
		
	}
	
	
	public String getResource() {
		return resource;
	}
	
	
	
}
