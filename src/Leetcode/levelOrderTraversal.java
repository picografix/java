package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {

}
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

class TreeNode {
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
class SolutionTreee {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> tempQ = new ArrayDeque<>();
            while (!que.isEmpty()){
                temp.add(que.peek().val);
                if(que.peek().left!=null){
                    tempQ.add(que.peek().left);
                }
                if(que.peek().right!=null){
                    tempQ.add(que.peek().right);
                }

                que.remove();
            }
            while(!tempQ.isEmpty()){
                que.add(tempQ.remove());
            }

            li.add(temp);

        }
        return li;
    }
}