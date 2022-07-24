class Solution {
    public int removeDuplicates(int[] nums) {
        int currentIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[currentIndex] != nums[i]){
                currentIndex++;
                nums[currentIndex] = nums[i];
            }
        }
        if(nums[currentIndex] != nums[nums.length -1]){
            nums[++currentIndex] = nums[nums.length -1];
        }
        return currentIndex + 1;
    }
}