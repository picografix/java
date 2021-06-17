package Leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class sortedArrayBinaryTree {
    public void generateTree(TreeNode root, int[] nums){
        if(nums.length==0){
//            System.out.println("sad");
            root=null;
            return;
        }
        int i = (nums.length-1)/2 ;
        if(i!=0 ){
            root.left = new TreeNode();
        }
        if(i!=nums.length-1){
            root.right = new TreeNode();
        }



        root.val = nums[i];
        try {
            generateTree(root.right, Arrays.copyOfRange(nums,i+1,nums.length));
            generateTree(root.left,Arrays.copyOfRange(nums,0,i));
        } catch (NullPointerException n){
            System.out.println("balle balle");
        }


    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        generateTree(root,nums);
        return root;
    }
    public void print(TreeNode root){
        if(root==null){
            return;
        }
        print(root.left);

        System.out.println(root.val);

        print(root.right);
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8};
        sortedArrayBinaryTree s = new sortedArrayBinaryTree();

        TreeNode root = s.sortedArrayToBST(nums);
        s.print(root);
    }
}

