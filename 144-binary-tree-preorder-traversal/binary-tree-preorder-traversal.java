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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        preorder(root, tree);
        return tree;
    }

    public void preorder(TreeNode root, List<Integer> tree){
        if(root == null) return;

        tree.add(root.val);
        preorder(root.left, tree);
        preorder(root.right,tree);
    }
}