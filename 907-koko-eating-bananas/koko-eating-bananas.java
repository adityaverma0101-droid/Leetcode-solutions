class Solution {
    long fun(int[] piles, int n, int speed){
        long hours=0;
        for(int i=0;i<n;i++){
            hours += (piles[i] + speed - 1) / speed;
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=0;
        //maximum value in pile
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            long hours=fun(piles,n,guess);
            if(hours>h){//no
                low=guess+1;
            }
            else{//yes
                res=guess;
                high=guess-1;
            }
        }
        return res;
        
    }
}