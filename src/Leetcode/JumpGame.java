package Leetcode;
import java.io.*;
import java.util.*;

public class JumpGame {
    Map<Integer, Boolean> dict = new HashMap<>();
    public boolean canJump(int[] nums,int start) {

        if(start==nums.length-1){
            return true;
        } else if(start>=nums.length){
            return false;
        } else if(dict.containsKey(start)){
            return dict.get(start);
        }
        boolean ans = false;
       for(int i=start;i<nums.length-1;i++){
           if(nums[i]==0){
               dict.put(start,false);
               return false;
           }
           for(int j=nums[i];j >=1;j--){
               ans = ans || canJump(nums,j+start);
               if(ans){
                   dict.put(start,ans);
                   return ans;
               }

           }
       }
       dict.put(start,ans);
       return ans;
    }
    public boolean canJump(int[] nums) {
        return canJump(nums,0);
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3};
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(nums));
    }
}
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

// This class represents a directed graph using adjacency list
// representation
class Solutionasdasd {

    Boolean[] memo;

    boolean canJumpTab(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i=0; i < dp.length; i++) {
            if (dp[i]) {
                for(int j=0; j < nums[i] && i+j+1 < dp.length; j++) {
                    if (i+j+1 == dp.length-1) return true;
                    dp[i+j+1] = true;
                }
            }
        }
        return dp[nums.length-1];
    }

    boolean canJumpRec(int[] nums, int idx) {
        if (memo[idx] != null) return memo[idx];
        if (idx >= nums.length - 1) return true;
        if (nums[idx] == 0) return false;

        for(int i=0; i < nums[idx]; i++) {
            if (canJumpRec(nums, idx+i+1)) {
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        /*memo = new Boolean[nums.length];
        return canJumpRec(nums, 0);*/
        return canJumpTab(nums);
    }
}
// This code is contributed by Aakash Hasija
