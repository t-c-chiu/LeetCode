package medium;

import java.util.*;

public class MakingFileNamesUnique {
	
	public static void main(String[] args) {
		String[] res = getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"});
		System.out.println(Arrays.toString(res));
	}
	
	public static String[] getFolderNames(String[] names) {
		Map<String, Integer> map = new HashMap<>();
		int n = names.length;
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			String name = names[i];
			if (map.containsKey(name)) {
				Integer version = map.get(name);
				while (map.containsKey(name + "(" + version + ")")) {
					version++;
				}
				String fileName = name + "(" + version + ")";
				res[i] = fileName;
				map.put(fileName, 1);
				map.put(name, version + 1);
			} else {
				map.put(name, 1);
				res[i] = name;
			}
		}
		return res;
	}
}
