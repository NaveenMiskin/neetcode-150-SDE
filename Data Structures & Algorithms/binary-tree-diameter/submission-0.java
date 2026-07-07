/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxi = 0;
    public int maxHeight(TreeNode root) {
        if(root == null) return 0;

        int l = maxHeight(root.left);
        int r = maxHeight(root.right);

        maxi = Math.max(maxi, l + r);
        return 1 + Math.max(l, r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxi = 0;
        maxHeight(root);
        return maxi;
    }
}
