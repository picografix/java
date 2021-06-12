package Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class wiggleSort {


}
class SolutionW {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> myd = new ArrayDeque<>();
        for(int i:nums){
            myd.push(i);
        }
        for(int i=0;i< nums.length;i++){
            if(i%2==0){
                nums[i]=myd.removeFirst();
            }else{
                nums[i]=myd.removeLast();
            }
        }
    }
}