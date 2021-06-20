package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class binaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        List<Integer> ans = helper(root);
        return ans.get(1);
    }
    public List<Integer> helper(TreeNode root){
        if(root == null){
            return new ArrayList<>(Arrays.asList(0,Integer.MIN_VALUE));
        }
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);
        int maxChildBranchSum = Math.max(left.get(0),right.get(0));
        int maxSumBranch = Math.max(maxChildBranchSum + root.val, root.val);
        int maxSumTree = Math.max(maxSumBranch, left.get(0) + right.get(0) + root.val);
        int runningSum = Math.max(left.get(1), Math.max(right.get(1), maxSumTree));
        ArrayList<Integer> current = new ArrayList<>();
        current.add(maxSumBranch);
        current.add(runningSum);
        return current;
    }
}
