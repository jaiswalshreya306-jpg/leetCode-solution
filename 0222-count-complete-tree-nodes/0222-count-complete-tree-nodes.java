class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = leftHeight(root);
        int right = rightHeight(root);

        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes(root.left)
                 + countNodes(root.right);
    }

    public int leftHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public int rightHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}