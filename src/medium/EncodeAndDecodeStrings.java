package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
	
	public static void main(String[] args) {
		Codec codec = new Codec();
		String encode = codec.encode(Arrays.asList("asdasd", "doisjdioa", "kxzjxlcn"));
		System.out.println(encode);
		List<String> decode = codec.decode(encode);
		System.out.println(decode);
	}
	
	static public class Codec {
		
		// Encodes a list of strings to a single string.
		public String encode(List<String> strs) {
			StringBuilder builder = new StringBuilder();
			for (String str : strs) {
				builder.append(str.length()).append("/").append(str);
			}
			return builder.toString();
		}
		
		// Decodes a single string to a list of strings.
		public List<String> decode(String s) {
			List<String> res = new ArrayList<>();
			int from = 0;
			while (from < s.length()) {
				int slash = s.indexOf("/", from);
				int size = Integer.parseInt(s.substring(from, slash));
				from = slash + size + 1;
				res.add(s.substring(slash + 1, from));
			}
			return res;
		}
	}
}
