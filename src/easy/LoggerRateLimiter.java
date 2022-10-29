package easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	
	public static void main(String[] args) {
		Logger logger = new Logger();
		logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
		logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
		logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
		logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
		logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
		logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
	}
	
	static class Logger {
		
		Map<String, Integer> map;
		
		public Logger() {
			map = new HashMap<>();
		}
		
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!map.containsKey(message) || map.get(message) + 10 <= timestamp) {
				map.put(message, timestamp);
				return true;
			}
			return false;
		}
	}
}
