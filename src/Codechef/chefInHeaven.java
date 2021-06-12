package Codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

public class chefInHeaven {
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

    public static boolean goToHeaven(String S){
        double g=0;
//        int b=0;
        for(int i=0;i<S.length();i++){
            char life = S.charAt(i);
            if(life=='1'){
                g++;
            }

            if(g>=(double) S.length()/2){
//                System.out.println("G: "+g+" S: "+ S.length() );
                return true;
            } else {
                if(g>=(double) (i+1)/2 && g!=0){
//                    System.out.println("G: "+g+" I: "+ i );
//                    System.out.println("second one");
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) throws java.lang.Exception {
        chefInHeaven.FastReader s = new chefInHeaven.FastReader();
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            int L = s.nextInt();
            String S = s.nextLine();
            if(goToHeaven(S)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
