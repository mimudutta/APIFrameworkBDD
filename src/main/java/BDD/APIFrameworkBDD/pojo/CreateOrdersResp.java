package BDD.APIFrameworkBDD.pojo;

import java.util.List;

public class CreateOrdersResp {
	
	private List<OrderDetailsResp> orders;

	public List<OrderDetailsResp> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetailsResp> orders) {
		this.orders = orders;
	}
	

}
