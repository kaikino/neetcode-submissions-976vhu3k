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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode out = new TreeNode();
        search(root, p.val, q.val, out);
        return out.left;
    }
    int search(TreeNode a, int p, int q, TreeNode out) {
        if (a==null) {
            return 0;
        }
        int sum = search(a.left, p, q, out) + search(a.right, p, q, out);
        if (a.val == p || a.val == q) {
            sum++;
        }
        if (sum==2) {
            out.left = a;
            sum++;
        }
        return sum;
    }
}
