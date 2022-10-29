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
		public String encode(List<String> strs) {
			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s.length()).append('/').append(s);
			}
			return sb.toString();
		}
		
		// Decodes a single string to a list of strings.
		public List<String> decode(String s) {
			List<String> res = new ArrayList<>();
			int from = 0;
			while (from < s.length()) {
				int slash = s.indexOf('/', from);
				int len = Integer.parseInt(s.substring(from, slash));
				from = slash + 1 + len;
				res.add(s.substring(slash + 1, from));
				
			}
			return res;
		}
		// Encodes a list of strings to a single string.

	}
}
