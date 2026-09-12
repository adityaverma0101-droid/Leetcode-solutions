class Solution {
    public boolean ship(int[] weights, int n, int days, int guess){
        int day=1;
        int load=0;
        for(int i=0;i<n;i++){
            if(load+weights[i]>guess){
                day++;
                load=weights[i];
            }
            else{
                load=load+weights[i];
            }
        }
        if(day<=days){
            return true;
        }
        else{
            return false;
        }
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=0;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high=high+weights[i];
        }
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(ship(weights,n,days,guess)){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return res;
    }
}