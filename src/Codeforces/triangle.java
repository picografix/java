package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class triangle {
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

    public static void main(String[] args) {
        triangle.FastReader s = new triangle.FastReader();
        int n = s.nextInt();
        for(int i=0;i<n;i++) {
            int N = s.nextInt();
//            double P = Math.random();
//            int q = (int) (100*P);
//            int N = q;
            int a = (int) Math.sqrt(N/2);
//            int b = (int) a;
            int c = (int) Math.sqrt(N/4);
//            System.out.println(N);
            if ( ( N == 2* a* a) || ( N == 4*c*c)  ){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
//            long a=1000000000;
//            System.out.println(8*a);
        }
    }
}
