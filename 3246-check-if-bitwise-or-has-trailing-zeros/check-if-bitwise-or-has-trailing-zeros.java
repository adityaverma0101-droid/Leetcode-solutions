class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){//even no last bit=0, odd no last bit =1
            if(nums[i]%2==0){     //need to find two even
                count++;
            }
            if(count==2){
                return true;
            }
        }
        return false;
    }
}