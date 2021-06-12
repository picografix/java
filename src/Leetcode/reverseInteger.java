package Leetcode;

public class reverseInteger {
}
class SolutionInteger {
    public int reverse(int x) {
        long ans = 0;
        while(x  !=0){
            ans = 10*ans+((x%10))%10;
            x=x/10;
        }
        if(ans>= 2147483647L || ans<= -2147483648L){
            return 0;
        }
        return (int) ans;
    }
}