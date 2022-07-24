class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums)
                .filter(num -> !set.add(num))
                .findFirst()
                .isPresent();
    }
}