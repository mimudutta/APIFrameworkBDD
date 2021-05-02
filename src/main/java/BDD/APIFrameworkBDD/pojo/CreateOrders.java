package BDD.APIFrameworkBDD.pojo;

import java.util.List;

public class CreateOrders {
	
	private int corpId;
	private int companyId;
	private int programId;
	private String fromDate;
	private String toDate;
	private List<PayoutDetails> payoutDetails;
	
	public int getCorpId() {
		return corpId;
	}
	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public List<PayoutDetails> getPayoutDetails() {
		return payoutDetails;
	}
	public void setPayoutDetails(List<PayoutDetails> payoutDetails) {
		this.payoutDetails = payoutDetails;
	}
	

}
