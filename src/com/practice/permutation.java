package com.practice;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class permutation {
    static long count=0;
//    static Vector<String[]> V = new Vector<>();
    static Vector<String[]> permut = new Vector<>();
    static Vector<String[]> permut1 = new Vector<>();
    static Vector<String > dict = new Vector<>();
    public void permutations(String S){

    }
    static void swap(String str, int i, int j){
        str = str.substring(0,i)+str.charAt(j)+str.substring(i+1,j)+str.charAt(i)+str.substring(j,str.length());
    }
    static void printPermutn(String str){
        int i=0;

        for(int j=0;j<str.length();j++){
            String temp = str;
            temp = str.substring(1,j)+str.charAt(i)+str.substring(j,str.length());
            String[] ne = {temp};
            permut1.add(ne);
        }
    }
    static void printPermutn(String str, String ans)    {
        if (str.length() == 0) {
//            System.out.println(ans + " ");
            permut1.add(ans.trim().split("\\s+") );
//            count++;


            return;
        }

        for (int i = 0; i < str.length()/2 +1; i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutn(ros, ans + ch);
        }
    }
    public static void permutNow(String S){
        String temp = "";
        String temp1 = "";
        String temp2 = "";
        for(int i=0;i<S.length();i++){
            for(int f=i;f<S.length();f++){
                count++;
                temp = S.substring(0,i)+" "+S.substring(i,f)+" "+S.substring(f,S.length());
                permut.add(temp.trim().split("\\s+") );
//                temp = S.substring(0,i)+" "+S.substring(f,S.length())+" "+S.substring(i,f);
//                permut.add(temp.trim().split("\\s+") );
//                temp = S.substring(f,S.length())+" "+S.substring(0,i)+" "+S.substring(i,f);
//                permut.add(temp.trim().split("\\s+") );
            }
        }
    }
    public static void print(){
        for(int i = 0; i< permut.size(); i++){
            System.out.println(Arrays.toString(permut.get(i)));
        }
    }
    public static void printhis(){
        for(int i = 0; i< permut.size(); i++){
            System.out.println(Arrays.toString(permut1.get(i)));
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String S = "bait";
//        permutNow(S);
        printPermutn(S);
        for(int i=0;i < permut1.size();i++){
            permutNow(permut1.get(i)[0]);
        }
//        print();

        PrintWriter out = new PrintWriter("oceans.txt"); // Step 2

        for(int i = 0; i< permut.size(); i++){
            out.println(Arrays.toString(permut.get(i)));
        }

        // Close the file.
        out.close();  // Step 4
        System.out.println(count);


    }
}
