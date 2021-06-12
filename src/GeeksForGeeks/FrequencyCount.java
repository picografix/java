package GeeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;

class FrequencyCount {
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {   int arrn[] = arr.clone();
    Arrays.fill(arr,0);
        for(int i=0;i<N;i++){
            if(arrn[i]-1<N){
                arr[arrn[i]-1]+=1;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr={3,3,3,3};
        frequencyCount(arr,4,3);
        System.out.println(Arrays.toString(arr));
    }
}