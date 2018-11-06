package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public static void main(String[] args) {
		System.out.print(new UniqueEmailAddresses().numUniqueEmails(new String[]{
				"test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com"}));
	}
	
	public int numUniqueEmails(String[] emails) {
		Set<String> actualEmails = new HashSet<>();
		
		for (String email : emails) {
			int indexOfAt = email.indexOf("@");
			String localName = email.substring(0, indexOfAt);
			String domainName = email.substring(indexOfAt);
			if (localName.contains("+"))
				localName = localName.substring(0, localName.indexOf("+"));
			if (localName.contains("."))
				localName = localName.replace(".", "");
			actualEmails.add(localName + domainName);
		}
		
		return actualEmails.size();
	}
}
