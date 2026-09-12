class Solution {
    public boolean magnet(int[] position,int n, int m, int guess){
        int ball=1;
        int pos=position[0];
        for(int i=1;i<n;i++){
            int force=position[i]-pos;
            if(force<guess){
                continue;
            }
            ball++;
            pos=position[i];
        }
        if(ball>=m){
            return true;
        }
        else{
            return false;
        }
    }
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int low=1;
        int high=position[n-1]-position[0];
        int ans=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(magnet(position,n,m,guess)){
                ans=guess;
                low=guess+1;
            }
            else{
                high=guess-1;
            }
        }
        return ans;
    }
}