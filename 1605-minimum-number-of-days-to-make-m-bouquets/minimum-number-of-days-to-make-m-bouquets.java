class Solution {
    public boolean canMake(int[] bloomDay, int m, int k, int day){
        int flowers=0;
        int bouquets=0;
        for(int x : bloomDay){
            if(x<=day){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                }
            }
            else{
                flowers=0;
            }
        }
        return bouquets>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n){
            return -1;
        }
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int x : bloomDay){
            low=Math.min(low,x);
            high=Math.max(high,x);
        }
        while(low<=high){
            int guess=low + (high - low) / 2; //to avoid int overflow
            if(canMake(bloomDay,m,k,guess)){
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return low;
    }
}