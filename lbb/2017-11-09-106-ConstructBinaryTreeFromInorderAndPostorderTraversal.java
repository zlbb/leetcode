class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return Helper(postorder, postorder.length-1, inorder, 0, inorder.length - 1);
    }

    private TreeNode Helper(int[] postorder, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd])
                index = i;
        }
        root.left = Helper(postorder, postEnd - index + inEnd - 1, inorder, inStart, index - 1);
        root.right = Helper(postorder, postEnd - 1, inorder, index + 1, inEnd);
        return root;
    }
}