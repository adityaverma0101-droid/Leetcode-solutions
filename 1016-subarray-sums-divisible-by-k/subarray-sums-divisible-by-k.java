class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        freq.put(0,1); //prefix sum 0 occurs once
        int res=0;
        int sum=0;
        for(int num:nums){
            sum+=num;
            int rem=sum%k;
            if(rem<0){
                rem=rem+k;
            }
            //add previous occurence of the remainder
            res+=freq.getOrDefault(rem,0);
            //update the frequency
            freq.put(rem,freq.getOrDefault(rem,0)+1);
        }
        return res;
    }
}