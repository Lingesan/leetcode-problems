class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        return generateSubSetsWithoutDuplicate(nums,0, result);
    }
    
    public List<List<Integer>> generateSubSetsWithoutDuplicate(int[] nums,int index, List<List<Integer>> subSet){
        if(index >= nums.length){
            return subSet;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> list : subSet){
            List<Integer> addedList = new ArrayList<>(list);
            addedList.add(nums[index]);
            result.add(addedList);
            result.add(list);
        }
        return generateSubSetsWithoutDuplicate(nums, index+1,result);
    }
}