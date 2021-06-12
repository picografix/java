package Leetcode;

import java.util.*;
class duplicateBits {
    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        boolean[] bool = new boolean[strings.length-1];

        for(int i=0;i< strings.length;i++){
            if(bool[Integer.parseInt(strings[i])-1]){
                System.out.println(strings[i]);
                break;
            }else{
                bool[Integer.parseInt(strings[i])-1]=true;
            }
//            System.out.println(Arrays.toString(bool));
        }
    }

}