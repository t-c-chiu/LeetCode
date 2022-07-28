package medium;

import java.util.Stack;

public class DesignBrowserHistory {
	
	public static void main(String[] args) {
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
		browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
		browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
		browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
		browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
		browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
		browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
		browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
	}
	
	static class BrowserHistory {
		
		Stack<String> history;
		Stack<String> forward;
		
		public BrowserHistory(String homepage) {
			history = forward = new Stack<>();
			history.push(homepage);
		}
		
		public void visit(String url) {
			history.push(url);
			forward = new Stack<>();
		}
		
		public String back(int steps) {
			while (steps > 0 && history.size() > 1) {
				forward.push(history.pop());
				steps--;
			}
			return history.peek();
		}
		
		public String forward(int steps) {
			while (steps > 0 && !forward.isEmpty()) {
				history.push(forward.pop());
				steps--;
			}
			return history.peek();
		}
	}
}
