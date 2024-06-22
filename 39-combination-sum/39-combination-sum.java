class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        recursivelyAddCombinations(Arrays.stream(candidates).sorted().toArray(), 0, target, new ArrayList<>(), list);
        return list;
    }

    private void recursivelyAddCombinations(int[] candidates, int index, int target, List<Integer> currentList,
            List<List<Integer>> combinations) {
        if (candidates.length == index) {
            return;
        }
        int value = candidates[index];
        if (value > target) {
            return;
        } else if (value == target) {
            currentList.add(value);
            combinations.add(currentList);
            return;
        }
        recursivelyAddCombinations(candidates, index + 1, target, new ArrayList<>(currentList), combinations);
        currentList.add(value);
        recursivelyAddCombinations(candidates, index, target - value, new ArrayList<>(currentList), combinations);

    }
}