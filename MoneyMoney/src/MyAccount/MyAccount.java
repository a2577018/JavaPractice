package MyAccount;

import java.io.Serializable;

public class MyAccount implements Comparable<MyAccount>, Serializable {
	private static final long serialVersionUID = 1L;
	String name ;
	Integer cost ;
	String date ;
	
	public MyAccount( String inputName, Integer inputCost, String inputDate ) {
		this.name = inputName ;
		this.cost = inputCost ;
		this.date = inputDate ;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getCost() {
		return cost;
	}
	
	public String getDate() {
		return date;
	}
	
	public int compareTo( MyAccount obj ) {
		return this.cost.compareTo(obj.cost) ;
	}
	
	public void show(){
		System.out.println("=================") ;
		System.out.println("名稱：" + name) ;
		System.out.println("花費:" + cost) ;
		System.out.println("日期:" + date) ;
	}
	
} // class MyAccount