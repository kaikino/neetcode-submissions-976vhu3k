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
        if (root == null) {return "n,";}
        
        String b = Integer.toString(root.val) + "," + serialize(root.left) + serialize(root.right);
        return b;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = {0};
        return help(data, i);
    }
    TreeNode help(String data, int[] i) {
        if (data.length() == i[0]) {
            return null;
        }
        String word = "";
        while (data.charAt(i[0]) != ',') {
            word += data.charAt(i[0]);
            i[0]++;
        }
        i[0]++;
        if (word.equals("n")) {
            return null;
        }
        System.out.println(word);
        return new TreeNode(Integer.parseInt(word), help(data, i), help(data, i));
    }
}
