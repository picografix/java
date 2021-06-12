package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class redandblue {
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
        public static boolean success(int r,int b, int d){
            if(d==0){
                return r==b;
            }
            int min = Math.min(r,b);
            int max = Math.max(r,b);
            int diff = max-min;
            int q = diff/d;
            if(diff <= min*d){
                return true;
            }
            return false;
        }
        public static void main(String[] args) {
            FastReader s = new FastReader();
            int n = s.nextInt();
            for(int i=0;i<n;i++){
                String S = s.nextLine();
                String[] words = S.split("\\s+");
                int r = Integer.parseInt(words[0]);
                int b = Integer.parseInt(words[1]);
                int d = Integer.parseInt(words[2]);
            if(success(r,b,d)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }
}
