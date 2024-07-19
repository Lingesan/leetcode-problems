class Solution {
	public int uniquePaths(int m, int n) {

		Map<String, Integer> map = new HashMap<>();
		return uniquePaths(m, n, map);
	}

	private int uniquePaths(int m, int n, Map<String, Integer> map) {
		if (m == 1 || n == 1) {
			return 1;
		}
		String key = m + "~" + n;
		if(map.containsKey(key)){
			return map.get(key);
		}
		int paths = uniquePaths(m-1, n, map) + uniquePaths(m, n-1, map);
		map.put(m + "~" + n, paths);
		map.put(n + "~" + m, paths);
		return paths;
	}
}