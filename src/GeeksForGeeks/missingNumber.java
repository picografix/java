package GeeksForGeeks;

class missingNumber {

    public static int missingNumber(int A[], int N)
    {
        for(int i=0; i < A.length;i++){
            N = N-A[i];
        }
        return N;

    }
}