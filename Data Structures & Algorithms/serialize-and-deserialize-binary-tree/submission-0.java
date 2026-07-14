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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String res = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                res += "n ";
                continue;
            }
            res += node.val + " ";
            q.offer(node.left);
            q.offer(node.right);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] value = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i < value.length; i++) {
            TreeNode parent = q.poll();
            if(!value[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                parent.left = left;
                q.offer(left);
            }

            if(!value[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
