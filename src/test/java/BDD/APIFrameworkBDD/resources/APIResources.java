package BDD.APIFrameworkBDD.resources;

public enum APIResources {
	
	
	createOrder("/sodexo/orders"),
	cancelOrder("/sodexo/orders/386553/cancel"),
	cancelPayout("/sodexo/orders/102473/payouts/cancel");
	
	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
