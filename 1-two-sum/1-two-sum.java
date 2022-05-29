import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> cache = new HashMap<>();
       for(int i=0;i<nums.length;i++){
           if(!cache.containsKey(nums[i])){
             cache.put(nums[i],i);
           }
           int secondNum = target - nums[i];
           if(cache.containsKey(secondNum) && cache.get(secondNum) != i){
               return new int[]{cache.get(secondNum), i};
           }
       }
        throw new IllegalStateException("Invalid input");
 
    }
}