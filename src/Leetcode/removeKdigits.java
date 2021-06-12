package Leetcode;

public class removeKdigits {


    public static String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        char[] ar = new char[arr.length];
        ar[0]=arr[0];
        int j=0;
        int i=1;
        while(i<arr.length){
            if(ar[j]<arr[i]){
                if(k==0){
                    j++;
                    ar[j]=arr[i];
                }else{
                    k--;
                }
            }else{
                if(k==0){
                    j++;
                    ar[j]=arr[i];
                }else{
                    ar[j]=arr[i];
                    k--;
                }
            }
            i++;
        }
        String fin = String.valueOf(ar);
        int p=0;
        while(p<fin.length()){
            if (fin.charAt(p)=='0'){
                p++;
            }else{
                break;
            }
        }

//        int ans = Integer.parseInt(String.valueOf(ar));
//        String fin = ""+ ans;
        return fin.substring(p,fin.length());
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }
}

