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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        return dive(root, k, count);
    }
    int dive(TreeNode cur, int k, int[] count) {
        if (cur == null) {
            return 0;
        }
        int left = dive(cur.left, k, count);
        count[0]++;
        if (count[0] == k) {
            return cur.val;
        }
        int right = dive(cur.right, k, count);
        return left+right;
    }
}
