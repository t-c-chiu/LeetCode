package easy;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {
	
	public static void main(String[] args) {
		String res = reformatDate("20th Oct 2052");
		System.out.println(res);
	}
	
	public static String reformatDate(String date) {
		Map<String, String> map = new HashMap<>();
		map.put("Jan", "01");
		map.put("Feb", "02");
		map.put("Mar", "03");
		map.put("Apr", "04");
		map.put("May", "05");
		map.put("Jun", "06");
		map.put("Jul", "07");
		map.put("Aug", "08");
		map.put("Sep", "09");
		map.put("Oct", "10");
		map.put("Nov", "11");
		map.put("Dec", "12");
		String[] info = date.split(" ");
		String year = info[2];
		String month = map.get(info[1]);
		String day = info[0].length() == 3 ? "0" + info[0].charAt(0) : info[0].substring(0, 2);
		return year + "-" + month + "-" + day;
	}
}
