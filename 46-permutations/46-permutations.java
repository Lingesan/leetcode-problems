class Solution {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,new ArrayList<>());
        return result;
    }
    
    private void permute(int[] nums, List<Integer> currentList){
        if(currentList.size() == nums.length){
            result.add(new ArrayList(currentList));
            return;
        }
        for(int num: nums){
            if(currentList.contains(num)){
                continue;
            }
            currentList.add(num);
            permute(nums, currentList);
            currentList.remove(currentList.size() - 1);
            
        }
    }
}