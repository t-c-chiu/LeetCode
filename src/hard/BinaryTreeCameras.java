package hard;

import util.TreeNode;

public class BinaryTreeCameras {
	
	public static void main(String[] args) {
		int res = minCameraCover(TreeNode.generateRoot(new Integer[]{0, 0, null, 0, 0}));
		System.out.println(res);
	}
	
	static int res;
	static final int NO_CAMERA = 0;
	static final int HAS_CAMERA = 1;
	static final int NO_NEEDED = 2;
	
	public static int minCameraCover(TreeNode root) {
		if (dfs(root) == NO_CAMERA) {
			res++;
		}
		return res;
	}
	
	private static int dfs(TreeNode node) {
		if (node == null) {
			return NO_NEEDED;
		}
		int left = dfs(node.left), right = dfs(node.right);
		if (left == NO_CAMERA || right == NO_CAMERA) {
			res++;
			return HAS_CAMERA;
		} else if (left == HAS_CAMERA || right == HAS_CAMERA) {
			return NO_NEEDED;
		} else {
			return NO_CAMERA;
		}
	}
}
