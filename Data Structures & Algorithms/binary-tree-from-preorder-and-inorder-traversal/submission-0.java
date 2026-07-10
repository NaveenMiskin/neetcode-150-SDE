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
    public TreeNode build(int[] preorder, int preSt, int preEnd, 
                            int[] inorder, int inSt, int inEnd,
                            Map<Integer, Integer> inmap) {
        if(preSt > preEnd || inSt > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preSt]);

        int inroot = inmap.get(root.val);
        int left = inroot - inSt;

        root.left = build(preorder, preSt + 1, preSt + left, inorder, inSt, inroot - 1, inmap);
        root.right = build(preorder, preSt + left + 1, preEnd, inorder, inroot + 1, inEnd, inmap);
        
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length, inmap);
        return root;
    }
}
