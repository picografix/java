package GeeksForGeeks;

class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        char[] arr = str.toCharArray();
        char[] rev = new char[arr.length];
        for(int i=0;i<arr.length/2 ;i++){
            int j = arr.length-1-i;
            arr[i] = (char) (arr[i] ^ arr[j]);
            arr[j] = (char) (arr[i] ^ arr[j]);
            arr[i] = (char) (arr[i] ^ arr[j]);
        }
        return String.valueOf(arr);
        // Reverse the string str
    }
}
