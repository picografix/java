package Leetcode;

public class maxDepth {
    public static void main(String[] args) {
        SolutionMaxDepth S = new SolutionMaxDepth();
        System.out.println();
    }
}
class SolutionMaxDepth {
    public int depth(TreeNode root,int a){
        if(root==null){
            return a-1;
        } else{
            return Math.max(depth(root.left,a+1),depth(root.right,a+1));
        }
    }
    public int maxDepth(TreeNode root) {
        return depth(root,0);
    }
}