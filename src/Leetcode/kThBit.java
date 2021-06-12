package Leetcode;

public class kThBit {
    public static void main(String[] args) {
        Solution1 S = new Solution1();
        System.out.println(S.findKthBit(4,11));
    }
}

/*
S1 = "0"
Si = Si-1 + "1" + reverse(invert(Si-1))
*/
/*
* Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
* */
class Solution1 {
    public String reverse(String S){
        StringBuilder sb=new StringBuilder(S);
        sb.reverse();
        return sb.toString();
    }

    public String invert(String S){
        char[] arr = S.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='0'){
                arr[i]='1';
            }else{
                arr[i]='0';
            }
        }
        return String.valueOf(arr);
    }
    public String revInv(String S){
        int n = S.length();
        char[] arr = new char[n];
        for(int i=0;i<n;i++){
            int j = n-i-1;
            if(S.charAt(i)=='0'){
                arr[j]='1';
            }else{
                arr[j]='0';
            }
        }
        return  String.valueOf(arr);
    }

    public char findKthBit(int n, int k) {
        String S1 = "0";
        for(int i=2;i<=n;i++){
//            S1 = S1 + "1"+ reverse(invert(S1));
            S1 = S1 + "1"+ revInv(S1);
        }
//        System.out.println(S1);
        return S1.charAt(k-1);
    }
}