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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        help(root, out, 0);
        return out;
    }
    void help(TreeNode root, List<List<Integer>> out, int depth) {
        if (root == null) {
            return;
        }
        if (!(out.size() > depth)) {
            out.add(new ArrayList<>());
        }
        out.get(depth).add(root.val);
            
        help(root.left, out, depth+ 1);
        help(root.right, out, depth+ 1);
    }
}
