class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return Helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode Helper(int[] preorder, int pStart, int[] inorder, int inStart, int inEnd) {
        if (pStart >= preorder.length || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[pStart])
                index = i;
        }
        root.left = Helper(preorder, pStart + 1, inorder, inStart, index - 1);
        root.right = Helper(preorder, pStart + index - inStart + 1, inorder, index + 1, inEnd);
        return root;
    }
}