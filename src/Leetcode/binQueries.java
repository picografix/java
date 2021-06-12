package Leetcode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class binQueries {
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

        int[] myarr = new int[32];

        Map<String, Integer> mymap = new HashMap<>();
        HashSet<Integer> myHash = new HashSet<>();
        mymap.put("CLR",0);
        mymap.put("SET",1);
        mymap.put("OR",2);
        mymap.put("AND",3);
//        System.out.println(mymap.size());
        binQueries.FastReader sc1 = new binQueries.FastReader();
        int N = sc1.nextInt();
//        sc.close();
        int[] arr = new int[N];
        while(N>0){
            String S = sc1.nextLine();

//            System.out.println(S);
            String[] str = S.split(" ");
//            System.out.println(Arrays.toString(str));
            if(str[0].equals("CLR")){
//                System.out.println("if: "+Integer.parseInt(str[1]));
                myarr[Integer.parseInt(str[1])]=0;
                myHash.add(Integer.parseInt(str[1]));
            }else if(str[0].equals("SET")){
                myarr[Integer.parseInt(str[1])]=1;
                myHash.add(Integer.parseInt(str[1]));
            }else if(str[0].equals("OR")){
                myarr[Integer.parseInt(str[1])]= myarr[Integer.parseInt(str[1])] | myarr[Integer.parseInt(str[2])];
                if(myHash.contains(Integer.parseInt(str[1])) && myHash.contains(Integer.parseInt(str[2]))){
                    myHash.add(Integer.parseInt(str[1]));
                }else if(myHash.contains(Integer.parseInt(str[1])) && myarr[Integer.parseInt(str[1])]==1 || myHash.contains(Integer.parseInt(str[2])) && myarr[Integer.parseInt(str[2])]==1 ){
//                    System.out.println("my iffinf");
                    myarr[Integer.parseInt(str[1])]= myarr[Integer.parseInt(str[1])] | myarr[Integer.parseInt(str[2])];
                    myHash.add(Integer.parseInt(str[1]));
                }
                else{
                    myHash.remove(Integer.parseInt(str[1]));
                }

            }else{

                if(myHash.contains(Integer.parseInt(str[1])) && myHash.contains(Integer.parseInt(str[2]))){
                    myHash.add(Integer.parseInt(str[1]));
                    myarr[Integer.parseInt(str[1])]= myarr[Integer.parseInt(str[1])] & myarr[Integer.parseInt(str[2])];
                }else if(myHash.contains(Integer.parseInt(str[1])) && myarr[Integer.parseInt(str[1])]==0 || myHash.contains(Integer.parseInt(str[2])) && myarr[Integer.parseInt(str[2])]==0 ){
//                    System.out.println("my iffinf");
                    myarr[Integer.parseInt(str[1])]= myarr[Integer.parseInt(str[1])] & myarr[Integer.parseInt(str[2])];
                    myHash.add(Integer.parseInt(str[1]));
                }
                else{
                    myHash.remove(Integer.parseInt(str[1]));
                }
            }
        N--;
        }
//        myarr[1]=1;
//        System.out.println(myHash.toString());
        for(int i=myarr.length-1;i>=0 ;i--){
            if(!myHash.contains(i)){
                System.out.print("#");
            }else{
                System.out.print(myarr[i]);
            }
        }
    }
}
/*
* HI
*
*
* */