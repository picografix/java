package Codechef.MayLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solubility {
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
        Solubility.FastReader s = new Solubility.FastReader();
        int T = s.nextInt();
        while(T>0){
            String S = s.nextLine();
            String[] arr = S.split("\\s+");
            int X = Integer.parseInt(arr[0]);
            int A = Integer.parseInt(arr[1]);
            int B = Integer.parseInt(arr[2]);
            X = 100 - X;
            int ans = (A+ B*X)*10;
            System.out.println(ans);
            T--;
        }

    }
}
