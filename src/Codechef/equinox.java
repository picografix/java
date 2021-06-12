package Codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

public class equinox {
    public static final String str = "EQUINOX";
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
    public static boolean check(char C){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==C){
                return true;
            }
        }
        return false;
    }
    public static boolean contains(String S){

        return check(S.charAt(0));
    }
    public static void main(String[] args) throws java.lang.Exception {
        equinox.FastReader s = new equinox.FastReader();
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            String S = s.nextLine();
            String[] words = S.split("\\s+");
            int N = Integer.parseInt(words[0]);
            int A = Integer.parseInt(words[1]);
            int B = Integer.parseInt(words[2]) ;
            long sarthak = 0;
            long anuradha = 0;
//            String[] mylist = new String[N];
            for(int j=0;j<N;j++){
                String bb = s.nextLine();
                if(contains(bb)){
                    sarthak+=A;
                }else {
                    anuradha+=B;
                }
            }
            if(sarthak>anuradha){
                System.out.println("SARTHAK");
            }else if(sarthak<anuradha){
                System.out.println("ANURADHA");
            } else {
                System.out.println("DRAW");
            }
        }

    }
}
