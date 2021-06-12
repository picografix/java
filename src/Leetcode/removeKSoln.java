package Leetcode;

public class removeKSoln {
}
/*
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k)return "0";
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }
            else if(stack.peek()<c){
                stack.push(c);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>c && k>0){ // pop it
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }
        }
        while(k!=0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String ans = sb.reverse().toString();

        //remove padded zeros
        int idx = 0;
        while(ans.length()>=2 && idx<ans.length()){
            if(ans.charAt(idx)=='0'){
                idx++;
            }
            else break;
        }

        return ans.substring(idx,ans.length()).length()==0?"0":ans.substring(idx,ans.length());
    }
}*/
