class Solution {
    public boolean canDistribute(int[] candies, long k, int mid){
        long children=0;
        for(int x : candies){
            children+=x/mid;
        }
        return children>=k;
    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int low=1;
        int high=0;
        for(int x : candies){
            high=Math.max(high,x);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canDistribute(candies,k,mid)){
                ans=mid;
                low=mid+1;//right jao
            }
            else{
                high=mid-1;//left jao
            }
        }
        return ans;

    }
}