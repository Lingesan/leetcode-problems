class Solution {
    public int maxArea(int[] height) {
        int left=0, right =height.length - 1;
        int maxArea = 0;
        while(left < right){
            int actualHeight = Math.min(height[left],height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, actualHeight* width );
            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }
            
        }
        return maxArea;
    }
}