package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class StockPrice {

    public int maxProfit(int[] prices) {
        if(prices.length==1 || prices.length==0){
            return 0;
        }

        int max = 0;
        int low=prices[0];
        for(int i = 1;i<prices.length-1;i++){
            low = Math.min(prices[i],low);
            max = Math.max(prices[i]-low,max);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
