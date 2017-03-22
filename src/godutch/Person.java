package godutch;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String m_name;
	private double m_totalPayment;
	private List<Bill> m_bills;
	
	public Person (String name) {
		this.m_name = name;
		this.m_bills = new ArrayList<Bill>();
	}
	
	public void addShare(Bill bill, double amount) {
		bill.addShare(this, amount);
		m_totalPayment += amount;
		m_bills.add(bill);
	}
	
}
