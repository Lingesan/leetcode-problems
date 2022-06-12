class Solution {
  
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        findSubsets(nums,0,new ArrayList<>());
        return result;
    }
    
    
    private void findSubsets(int[] nums, int index,List<Integer> currentSubSet){
        result.add(new ArrayList<>(currentSubSet));
        for(int i= index; i< nums.length;i++){
            if(index != i && nums[i] == nums[i-1]){ // To remove duplicates
                continue;
            }
            currentSubSet.add(nums[i]);
            findSubsets(nums, i+1, currentSubSet);
            currentSubSet.remove(currentSubSet.size() - 1);
        }
    } 
    
}