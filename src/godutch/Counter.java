package godutch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Counter {
	
	class Diff {
		public String p_name;
		public double diff;
		
		public Diff (String p_name, double diff) {
			this.p_name = p_name;
			this.diff = diff;
		}
	}
	
	public String countTransfers(List<Person> persons) {
		double total = 0;
		for (Person person : persons) {
			total += person.getTotalPayment();
		}
		double avg = total / persons.size();
		
		persons.sort(new Comparator<Person>() {
			public int compare (Person p1, Person p2) {
				if (p1.getTotalPayment() < p2.getTotalPayment()) {
					return -1;
				} else if (p1.getTotalPayment() == p2.getTotalPayment()) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		
		List<Diff> diffs = new ArrayList<Diff>();
		for (Person person : persons) {
			diffs.add(new Diff(person.getName(), person.getTotalPayment() - avg));
		}
		
		int start = 0, end = diffs.size() - 1;
		while (start < end) {
			
		}
	}

}
