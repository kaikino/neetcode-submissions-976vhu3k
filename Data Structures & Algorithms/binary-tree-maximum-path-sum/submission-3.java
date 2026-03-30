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
    public int maxPathSum(TreeNode root) {
        int[] max = {root.val};
        dive(root, max);
        return max[0];
    }
    int dive(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = dive(root.left, max);
        int right = dive(root.right, max);
        int sum = root.val + left + right;
        if (sum > max[0]) {
            max[0] = sum;
        }
        return Math.max(0, root.val + Math.max(left, right));
    }
        
}
