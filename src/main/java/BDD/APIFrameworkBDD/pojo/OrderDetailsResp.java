package BDD.APIFrameworkBDD.pojo;

import java.util.List;

public class OrderDetailsResp {
	
	private int orderId;
	private String scheduledDate;
	private String orderStatus;
	private List<PayoutDetailsResp> payoutDetails;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<PayoutDetailsResp> getPayoutDetails() {
		return payoutDetails;
	}
	public void setPayoutDetails(List<PayoutDetailsResp> payoutDetails) {
		this.payoutDetails = payoutDetails;
	}
	
	
}
