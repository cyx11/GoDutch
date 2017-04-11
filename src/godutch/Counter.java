package godutch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Counter {
	
	class Diff {
		public String p_name;
		public double val;
		
		public Diff (String p_name, double val) {
			this.p_name = p_name;
			this.val = val;
		}
	}
	
	public String countTransfers(List<Person> persons) {
		
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
		
		double total = 0;
		for (Person person : persons) {
			total += person.getTotalPayment();
		}
		double avg = total / persons.size();
		List<Diff> diffs = new ArrayList<Diff>();
		for (Person person : persons) {
			diffs.add(new Diff(person.getName(), person.getTotalPayment() - avg));
		}
		
		int start = 0, end = diffs.size() - 1;
		StringBuilder sb = new StringBuilder();
		while (start < end) {
			Diff diffStart = diffs.get(start);
			Diff diffEnd = diffs.get(end);
			if (Math.abs(diffStart.val) < Math.abs(diffEnd.val)) {
				sb.append(diffStart.p_name + "->" + diffEnd.p_name + " " + Math.abs(diffStart.val));
				diffEnd.val -= Math.abs(diffStart.val);
				start++;
			} else if (Math.abs(diffStart.val) > Math.abs(diffEnd.val)) {
				sb.append(diffStart.p_name + "->" + diffEnd.p_name + " " + Math.abs(diffEnd.val));
				diffStart.val += Math.abs(diffEnd.val);
				end--;
			} else {
				start++; end--;
			}
		}
		return sb.toString();
	}

}
