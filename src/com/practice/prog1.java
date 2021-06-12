package com.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;


public class prog1 {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long getAns(long n){
        long count = 0;
        while(n>0){
            int k=0;

            while((long) 2050*Math.pow(10,k) <= n ){
                k++;

            }
            if((long) 2050*Math.pow(10,k) > n&&k!=0){
//                System.out.println("iffing");
                k--;
            }
//            System.out.println("N is: "+n);
//            System.out.println("POW is "+2050*Math.pow(10,k));
            n = (long) (n- 2050*Math.pow(10,k));
            count++;
        }

        if(n<0){

            return (-1);
        } else{
//            System.out.println(count);
            return (count);
        }

    }
    static long sumof(long l){
        long sum=0;
        while(l>0){
            sum+=l%10;
            l=l/10;
        }
        return sum;
    }
    static long getAAns(long l){
        long rem = l % 2050;
        long quo = l / 2050;
        if(rem!=0){
            return -1;
        }
        else{
            return sumof(quo);
        }
    }
    public static void main(String[] args) {
        prog1.FastReader s=new prog1.FastReader();
        int n = s.nextInt();

        for(int i =0;i<n;i++){
            long l = s.nextLong();
            System.out.println(getAAns(l));
        }
//        long n= 25308639900L;

    }
}
