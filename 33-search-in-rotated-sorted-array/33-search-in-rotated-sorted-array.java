class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0, end = length - 1;
        int pivot = findPivot(nums);
        System.out.println(pivot);
        while (start <= end) {
            int mid = (start + end) / 2;
            final int num = nums[(mid + pivot) % length];
            if (target == num) {
                return (mid + pivot) % length;
            } else if (target > num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    private int findPivot(int[] nums){
        if(nums.length == 1){
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if( mid < nums.length -1 && nums[mid] > nums[mid + 1]){
                return mid+1;
            } else if ( nums[start] <= nums[mid]){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return 0;
    }
}