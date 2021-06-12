package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

class Main {
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
        // Write your code here
        Main.FastReader fs = new Main.FastReader();
        int N = fs.nextInt();

        while(N>0){
            String S = fs.nextLine();
            String[] strings = S.split(" ");
            for(String s: strings){
                String bits = Long.toBinaryString(Long.parseLong(s));
                System.out.println(bits);
                StringBuilder A= new StringBuilder();
                StringBuilder B= new StringBuilder();
                for(int i=bits.length()-1;i>0;i--){
                    if((i%2)==0 && (bits.charAt(i)=='1')){
                        A.append(bits.charAt(i));
                        B.append("0");
                    }else if(bits.charAt(i)=='1'){
                        B.append(bits.charAt(i));
                        A.append("0");
                    } else{
                        A.append("0");
                        B.append("0");
                    }
                }
                System.out.println(A+" "+B);
            }

            N--;
        }
    }
}