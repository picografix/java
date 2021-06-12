package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class LongestSubstring {
    public static void main(String[] args) {
        SolutionSubString hola = new SolutionSubString();
        System.out.println(hola.lengthOfLongestSubstring("\"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABC\n"));
    }
}
class SolutionSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }else if(s.length()==0){
            return 0;
        }
        Hashtable<Character, Integer> myk = new Hashtable<>();
        int initial=0;
        char[] arr=s.toCharArray();
        myk.put(arr[0],0);
        String ans = "";
        for(int j=1;j<arr.length;j++){
            if(myk.containsKey(arr[j])){
                String temp = s.substring(initial,j);
                if(temp.length()>ans.length()){
                    ans=temp;
                }
                initial = Math.max(initial,myk.get(arr[j])+1);

//                System.out.println("Updated Initial: "+initial);
                myk.put(arr[j],j);
            }else{
                myk.put(arr[j],j);
            }
        }
        String temp = s.substring(initial,arr.length);
        if(temp.length()>ans.length()){
//            System.out.println("Initial: "+initial);
            ans=temp;
        }
        return ans.length();
    }
}

/*TLE :cry*/

/*
import java.util.*;
public int lengthOfLongestSubstring(String s) {
        int right, left = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
               max = Math.max(max, right - left);
               left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
             map.put(s.charAt(right), right);
        }
        return Math.max(max, right - left);
    }
* */