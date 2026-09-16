class Solution {
    public boolean canSplit(int[] nums, int k, int limit){
        int parts=1;
        int sum=0;
        for(int num : nums){
            if(num+sum<=limit){
                sum+=num;
            }
            else{
                parts++;
                sum=num;
            }
            if(parts>k){
                return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int low=0, high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<high){
            int guess=(low+high)/2;
            if(canSplit(nums,k,guess)){
                high=guess;
            }
            else{
                low=guess+1;
            }
        }
        return low;
    }
}