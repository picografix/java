package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Sock {
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

//    public static void main(String[] args) {
//        template.FastReader s = new template.FastReader();
//        int n = s.nextInt();
//        for(int i=0;i<n;i++) {
//            String S = s.nextLine();
//            String[] words = S.split("\\s+");
//            Vector<Integer> left = new Vector<>();
//            Vector<Integer> right = new Vector<>();
//            int N = Integer.parseInt(words[0]);
//            int L = Integer.parseInt(words[1]);
//            int R = Integer.parseInt(words[2]);
//            S = s.nextLine();
//            words = S.split("\\s+");
//            int req = N/2;
//            int count=0;
//            for(int j=0;j<N;j++){
//                if(j<L){
//                    left.add(Integer.parseInt(words[j]));
//                }else{
//                    int temp = Integer.parseInt(words[j]);
//                    if(left.contains(temp)){
//                        left.remove(temp);
//                        req--;
//                    }else{
//                        right.add(temp);
//                    }
//                }
//            }
//            if(req!=0){
//                if(left.size()>right.size()){
//                    while(left.size()!=right.size()){
//                        int tem = left.get(0);
//                        if(left.contains(tem)){
//                            left.remove(tem);
//                            count++;
//                        }
//                    }
//                }else if(left.size()<right.size()){
//                    while(left.size()!=right.size())
//                }else {
//
//                }
//            }else{
//                System.out.println(count);
//            }
//        }
//    }
}
