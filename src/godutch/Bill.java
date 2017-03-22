package godutch;

import java.util.HashMap;
import java.util.Map;

public class Bill {
	
	private String m_name;
	private String m_desp;
	private double m_totalAmount;
	private double m_payedAmount;
	private Map<Person, Double> m_shares;
	
	public Bill(String name, String desp, double amount) {
		this.m_name = name;
		this.m_desp = desp;
		this.m_totalAmount = amount;
		this.m_payedAmount = 0;
		this.m_shares = new HashMap<Person, Double>();
	}
	
	public void addShare(Person person, double amount) {
		if (m_shares.containsKey(person)) {
			m_shares.put(person, this.m_shares.get(person) + amount);
		} else {
			m_shares.put(person, amount);
		}
		m_payedAmount += amount;
	}

}
