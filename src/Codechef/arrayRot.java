package Codechef;
import java.util.*;
import java.lang.*;
import java.io.*;
class arrayRot {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static long arraysum(int[] arr){
        long sum = 0;
        for(int i: arr){
            sum+=i;
        }
        return (sum );
    }
    /*public static int[] solve(int[] arr,int x){
        int[] ans = new int[2*arr.length];

    }*/
    public static void main(String[] args) throws java.lang.Exception {
        arrayRot.FastReader s = new arrayRot.FastReader();
        int n = s.nextInt();
        String S = s.nextLine();
        String[] srr = S.split("\\s+");
//        int[] arr = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += Integer.parseInt(srr[i]);
        }
        int Q = s.nextInt();
        String q = s.nextLine();
        String[] qrr = q.split("\\s+");
        /*int[] xrr = new int[Q];
        for(int i=0;i<Q;i++){
            xrr[i] = Integer.parseInt(qrr[i]);
        }*/
//        long sum = arraysum(arr);
        long a=1;
        for(int j=0;j<Q;j++){

            a*=2;
//            sum = sum % 1000000007;
            System.out.println((sum*a) % 1000000007);

        }


    }
}
