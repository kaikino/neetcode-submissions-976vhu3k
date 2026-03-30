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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dive(p,q);
    }
    boolean dive(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null) {
                return true;
            }
            return false;
        }
        if (q == null) {
            return false;
        }
        return (p.val == q.val && dive(p.left, q.left) && dive(p.right, q.right));
    }
}
