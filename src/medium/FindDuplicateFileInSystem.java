package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateFileInSystem {
	
	public static void main(String[] args) {
		List<List<String>> res = findDuplicate(
				new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"});
		System.out.println(res);
	}
	
	public static List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] info = path.split(" ");
			String dir = info[0];
			for (int i = 1; i < info.length; i++) {
				String file = info[i];
				int bracketIdx = file.indexOf('(');
				String fileName = file.substring(0, bracketIdx);
				String content = file.substring(bracketIdx + 1, file.length() - 1);
				map.putIfAbsent(content, new ArrayList<>());
				map.get(content).add(dir + "/" + fileName);
			}
		}
		
		return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
	}
}
