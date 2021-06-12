package Leetcode;

import java.util.Stack;

public class isPalindrome {


}
class SolutionHello {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();

        for(int i=0 ; i<sb.length() ; i++) {
            char c = sb.charAt(i);
            if(Character.isDigit(c) || ( (int)c>=(int)'a' &&  (int)c<=(int)'z' ) || (  (int)c>=(int)'A' && (int)c<=(int)'Z'  )  )
                sb2.append(c);

        }

        // System.out.println(sb2);

        int l=0;
        int r= sb2.length()-1;

        while(l<=r){

            char c1=Character.toUpperCase(sb2.charAt(l));
            char c2=Character.toUpperCase(sb2.charAt(r));
            if(c1!=c2)
                return false;

            l++;
            r--;

        }
        return true;
    }
}