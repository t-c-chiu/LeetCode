package medium;

public class VerifyPreorderSerializationOfABinaryTree {
	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(isValidSerialization("1,#"));
		System.out.println(isValidSerialization("9,#,#,1"));
	}
	
	public static boolean isValidSerialization(String preorder) {
		int capacity = 1;
		for (String node : preorder.split(",")) {
			if (--capacity < 0) {
				return false;
			}
			if (!"#".equals(node)) {
				capacity += 2;
			}
		}
		return capacity == 0;
	}
}
