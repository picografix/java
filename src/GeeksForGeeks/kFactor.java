package GeeksForGeeks;

import java.util.Vector;

public class kFactor {
    public static void main(String[] args) {
        System.out.println(Solution1.kThSmallestFactor(4,3));
    }
}
class Solution1 {
    static int kThSmallestFactor(int N , int K) {
        // code here
        Vector<Integer> myvec = new Vector<>();
        for(int i=1;i<=N/2+1;i++){
//            System.out.println("forring");
            if(N%i==0){
                myvec.add(i);
            }
        }
        myvec.add(N);
        if(myvec.size()==0 || myvec.size() <K){
            return -1;

        }else{
            return myvec.get(K-1);
        }

    }
};