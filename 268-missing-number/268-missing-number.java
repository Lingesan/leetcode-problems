class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedSum = (length * (length +1))/2;
        int actualSum = IntStream.of(nums).sum();
        return expectedSum - actualSum;
    }
}