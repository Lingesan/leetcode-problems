class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int sum = 0;
        for(int i=0;i <nums.length;i++){
            leftSum[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for(int i=nums.length-1; i>= 0;i--){
            rightSum[i] = sum;
            sum += nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(rightSum[i] == leftSum[i]){
                return i;
            }
        }
        return -1;
    }
}