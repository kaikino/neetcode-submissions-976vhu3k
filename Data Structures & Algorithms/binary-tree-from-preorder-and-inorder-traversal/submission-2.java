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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> in = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        int[] preIdx = {1};
        TreeNode root = new TreeNode(preorder[0]);
        return build(0, preorder.length - 1, in.get(preorder[0]), preIdx, preorder, inorder, in);
        
    }
    TreeNode build(int l, int r, int mid, int[] preIdx, int[] preorder, int[] inorder, Map<Integer, Integer> in) {
        TreeNode left = null;
        TreeNode right = null;
        if (preIdx[0] < preorder.length) {
            int nextMid = in.get(preorder[preIdx[0]]);
            if (nextMid >= l && nextMid <= r) {
                if (nextMid < mid) {
                    preIdx[0]++;
                    left = build(l, mid - 1, nextMid, preIdx, preorder, inorder, in);
                }
                if (preIdx[0] < preorder.length) {
                    nextMid = in.get(preorder[preIdx[0]]);
                    if (nextMid >= l && nextMid <= r && nextMid > mid) {
                        preIdx[0]++;
                        right = build(mid + 1, r, nextMid, preIdx, preorder, inorder, in);
                    }
                }
            }
        }
        return new TreeNode(inorder[mid], left, right);
    }
}
