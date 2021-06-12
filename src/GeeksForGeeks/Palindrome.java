package GeeksForGeeks;

class Palindrome {
    int isDigitSumPalindrome(int N) {
        int sum = 0;
        while(N !=0){
            sum+= N %10;
            N=N/10;
        }
        String s = "" + sum;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length/2;i++){
            int j = arr.length-1-i;
            if(arr[i]!=arr[j]){
                return 0;
            }
        }
        return 1;
    }
}