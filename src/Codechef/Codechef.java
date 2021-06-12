package Codechef;
import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef{

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


    /*public static int[] solve(int[] arr,int x){
        int[] ans = new int[2*arr.length];

    }*/
    public static void main(String[] args) throws java.lang.Exception {
        Codechef.FastReader s = new Codechef.FastReader();
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            String S = s.nextLine();
            String[] words = S.split("\\s+");
            int N = Integer.parseInt(words[0]);
            int W = Integer.parseInt(words[1]);
            int WR = Integer.parseInt(words[2]);
            String SS = s.nextLine();
            String[] weights = SS.split("\\s+");
//            int[] arr=  new int[N];
            HashMap<Integer, Integer> h= new HashMap<>();
            for (String weight : weights) {
                int temp = Integer.parseInt(weight);
                if (h.containsKey(temp)) {
                    h.put(temp, h.get(temp) + 1);
                } else {
                    h.put(temp, 1);
                }
            }
            for(int a: h.keySet()){
                if((h.get(a) &1)!=0){
                    h.put(a,h.get(a)-1);
                }
            }

            int sum = W-WR;
            if(sum<=0){
                System.out.println("YES");
            } else{
                for(int a: h.keySet()){
                    sum = sum - a*h.get(a);
                    if(sum<=0){
                        System.out.println("YES");
                        break;
                    }
                }
            }

            if(sum > 0){
                System.out.println("NO");
            }
            for(int a: h.keySet()){
                System.out.println("A: "+a+" count: "+h.get(a));
            }
        }


    }
}
