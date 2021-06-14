package Leetcode;

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
class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;
    MyTreeNode() {}
    MyTreeNode(int val) { this.val = val; }
    MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class SolutionTRee {
    public boolean isSymmetric(MyTreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(MyTreeNode a, MyTreeNode b){
        if(a ==null && b == null) return true;
        if(a == null || b == null) return false;

        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}