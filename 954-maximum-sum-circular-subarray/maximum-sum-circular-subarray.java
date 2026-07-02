class Solution {
    //aditya
    public int maxSubarraySumCircular(int[] nums) {
        int maxEnd=0, maxSum=Integer.MIN_VALUE;
        int minEnd=0, minSum=Integer.MAX_VALUE;
        int totalSum=0;
        for(int num:nums){
            maxEnd=Math.max(num,maxEnd+num);
            maxSum=Math.max(maxSum,maxEnd);

            minEnd=Math.min(num,minEnd+num);
            minSum=Math.min(minSum,minEnd);
            totalSum+=num;
        }
        if(maxSum<0){
            return maxSum;
        }
        else{
            return Math.max(maxSum, totalSum-minSum);
        }
    }
}