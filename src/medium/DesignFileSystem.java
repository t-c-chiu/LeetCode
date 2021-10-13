package medium;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
	
	public static void main(String[] args) {
		FileSystem fileSystem = new FileSystem();
		fileSystem.createPath("/leet", 1); // return true
		fileSystem.createPath("/leet/code", 2); // return true
		fileSystem.get("/leet/code"); // return 2
		fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
		fileSystem.get("/c"); // return -1 because this path doesn't exist.
	}
	
	static class FileSystem {
		
		Map<String, Integer> map;
		
		public FileSystem() {
			map = new HashMap<>();
			map.put("", 0);
		}
		
		public boolean createPath(String path, int value) {
			if (map.containsKey(path)) {
				return false;
			}
			String parent = path.substring(0, path.lastIndexOf('/'));
			if (!map.containsKey(parent)) {
				return false;
			}
			map.put(path, value);
			return true;
		}
		
		public int get(String path) {
			return map.getOrDefault(path, -1);
		}
	}
}
