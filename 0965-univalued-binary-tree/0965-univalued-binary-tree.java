class Solution {
    public boolean helper(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        boolean leftAns = helper(root.left, val);
        boolean rightAns = helper(root.right, val);
        return leftAns && rightAns;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, root.val);
    }
}