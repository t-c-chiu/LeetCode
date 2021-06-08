package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
	
	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
		String res = timeMap.get("foo", 1);  // output "bar"
		System.out.println(res);
		res = timeMap.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
		System.out.println(res);
		timeMap.set("foo", "bar2", 4);
		res = timeMap.get("foo", 4); // output "bar2"
		System.out.println(res);
		res = timeMap.get("foo", 5); //output "bar2"
		System.out.println(res);
		
	}
	
	static class TimeMap {
		Map<String, TreeMap<Integer, String>> map;
		
		public TimeMap() {
			map = new HashMap<>();
		}
		
		public void set(String key, String value, int timestamp) {
			TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
			treeMap.put(timestamp, value);
			map.putIfAbsent(key, treeMap);
		}
		
		public String get(String key, int timestamp) {
			TreeMap<Integer, String> treeMap = map.get(key);
			Integer i = treeMap.floorKey(timestamp);
			return i != null ? treeMap.get(i) : "";
		}
	}
}
