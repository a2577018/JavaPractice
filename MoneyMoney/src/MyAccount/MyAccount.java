package MyAccount;

import java.io.Serializable;

public class MyAccount implements Comparable<MyAccount>, Serializable {
	private static final long serialVersionUID = 1L;
	String fatherCategory ;
	String sonCategory ;
	Integer cost ;
	String date ;
	
	public MyAccount( String fatherCategory, String sonCategory, Integer inputCost, String inputDate ) {
		this.fatherCategory = fatherCategory ;
		this.sonCategory = sonCategory ;
		this.cost = inputCost ;
		this.date = inputDate ;
	}
	
	public String getFatherCategory() {
		return this.fatherCategory;
	}
	
	public String getSonCategory() {
		return this.sonCategory;
	}	
	
	public Integer getCost() {
		return this.cost;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int compareTo( MyAccount obj ) {
		return this.cost.compareTo(obj.cost) ;
	}
	
	
} // class MyAccount