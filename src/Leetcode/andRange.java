package Leetcode;

import java.util.Scanner;

class andRange {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);
        int ans=A;
        for(int i=A+1;i<=B;i++){
            ans = ans & i;
        }
        System.out.println(ans);
    }
}