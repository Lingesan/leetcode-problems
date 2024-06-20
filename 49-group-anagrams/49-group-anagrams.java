class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<>();
        for (String word : strs) {
            long hash = hashWord(word);
            if (map.containsKey(hash)) {
                map.get(hash).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(hash, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public Long hashWord(String word) {
        long[] primes = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        return word.chars().map(a -> a - 'a').mapToLong(b -> primes[b]).reduce(1L, (a, b) -> (a * b) % 1000000009L);    }
}