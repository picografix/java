package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;

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
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class SolutionTRee {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode a, TreeNode b){
        if(a ==null && b == null) return true;
        if(a == null || b == null) return false;

        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}