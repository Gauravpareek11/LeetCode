class Solution {
    public int maxProfit(int[] prices) {
        // int minprice=Integer.MAX_VALUE;
        // int profit=0;
        // for(int i=0;i<prices.length;i++){
        //     if(prices[i]<minprice){
        //         minprice=prices[i];
        //     }
        //     else if(prices[i]-minprice>profit){
        //         profit=prices[i]-minprice;
        //     }
        // }
        // return profit;
        int[] index=new int[prices.length-1];
        for(int i=prices.length-1;i>0;i--){
            index[i-1]=prices[i]-prices[i-1];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<index.length;i++){
            max=Math.max(index[i],max);
        }
        if(max<0) return 0;
        int sum=0;
        for(int i=0;i<index.length;i++){
            sum+=index[i];
            if(sum<0) sum=0;
            else if(sum>max) max=sum;
            else continue;
        }
        return max;
    }
}