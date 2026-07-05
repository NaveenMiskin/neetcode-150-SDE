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
    public void rightViewofBT(TreeNode root, int level, List<Integer> rightview) {
        if(root == null) return;

        if(level == rightview.size()) {
            rightview.add(root.val);
        }
        rightViewofBT(root.right, level + 1, rightview);
        rightViewofBT(root.left, level + 1, rightview);

// for same problem left view we will just interchange the step left -> right
        // rigthViewofBT(root.left, level - 1, rightview);
        // rigthViewofBT(root.right, level + 1, rightview);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightview = new ArrayList<>();
        rightViewofBT(root, 0, rightview);
        return rightview;
    }
}
