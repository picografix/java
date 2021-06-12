package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Gold {
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
    public void print(int[] arr){
        for(int a: arr){
            System.out.print(a+" ");

        }
        System.out.println();
    }
    public void print(String[] arr){
        for(String a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Gold G = new Gold();
        Gold.FastReader s = new Gold.FastReader();

        int n = s.nextInt();
        for(int i=0;i<n;i++){
            String S = s.nextLine();
            String[] words = S.split("\\s+");
            int N = Integer.parseInt(words[0]);
            int X = Integer.parseInt(words[1]);
            S = s.nextLine();
            int sum=0;
            int[] arr = new int[N];
            String[] strings = S.split("\\s+");
            for(int j=0;j<strings.length;j++){
                int temp = Integer.parseInt(strings[j]);
                if(sum+temp !=X){
                    sum+=temp;
                    arr[j] =temp;
                } else{
                    if(j!=N-1){
                        int myTemp = Integer.parseInt(strings[j+1]);
                        strings[j]=""+myTemp;
                        strings[j+1]=""+temp;
                        sum+=myTemp;
                        arr[j] = myTemp;
//                        G.print(strings);
                    }else{
                        sum+=temp;
                        System.out.println("NO");
//                        break;
                    }
                }
            }
            if(sum != X){
                System.out.println("YES");
                G.print(arr);
            }
        }
    }
}
