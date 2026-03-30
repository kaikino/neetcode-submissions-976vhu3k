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
    public boolean isValidBST(TreeNode root) {
        return check(root.left, false, 0, true, root.val) && check(root.right, true, root.val, false, 0);
    }
    boolean check(TreeNode root, boolean mi, int min, boolean ma, int max) {
        if (root == null) {
            return true;
        }
        if (ma && root.val >= max || mi && root.val <= min) {
            return false;
        }
        return check(root.left, mi, min, true, root.val) && check(root.right, true, root.val, ma, max);
    }
}
