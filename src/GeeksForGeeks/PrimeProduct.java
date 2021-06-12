package GeeksForGeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class PrimeProduct {

    public static void main(String args[]) throws IOException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);

//            Solution ob = new Solution();
            System.out.println(Solution.primeProduct(L, R));
        }
    }

    /*public static void main(String[] args) {
        long L=1,R=20;
        long ans = Solution.primeProduct(L,R);
        System.out.println(ans);
    }*/
}
class Solution{
    static Vector<Long> primes;
    static boolean isPrime(long n){
        if(n==1){
            return false;
        }
        return checkPrime(n);
    }
    static void createVector(long L){
        primes = new Vector<>();
        for(long i=2;i<L;i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
    }
    static boolean checkPrime(long L){
        if(L==1){
            return false;
        }
        for(long i: primes){
            if(L%i==0){
//                System.out.println(L+" is not prime");
                return false;
            }
        }
        primes.add(L);
//        System.out.println(L+" is prime");
        return true;
    }
    static long primeProduct(long L, long R){
        long product = 1;
        createVector(L);
        while(L<=R){
            if(checkPrime(L)){
                product*=L;
            }
            L++;
        }
        return product;
    }
}