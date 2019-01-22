package medium;

public class VerifyPreorderSerializationOfABinaryTree {
	public static void main(String[] args) {
		VerifyPreorderSerializationOfABinaryTree verifyPreorderSerializationOfABinaryTree = new VerifyPreorderSerializationOfABinaryTree();
		System.out.println(verifyPreorderSerializationOfABinaryTree.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(verifyPreorderSerializationOfABinaryTree.isValidSerialization("1,#"));
		System.out.println(verifyPreorderSerializationOfABinaryTree.isValidSerialization("9,#,#,1"));
	}

	public boolean isValidSerialization(String preorder) {
		int capacity = 1;
		boolean isChildAllowed = true;
		for (String s : preorder.split(",")) {
			if (!isChildAllowed)
				return false;
			if ("#".equals(s)) {
				if (--capacity == 0)
					isChildAllowed = false;
			} else
				capacity++;
		}
		return capacity == 0;
	}
}
