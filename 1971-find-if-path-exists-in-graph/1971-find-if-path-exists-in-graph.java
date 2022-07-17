class Solution {
         public boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> pathMatrix = createPathMatrix(n, edges);

        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int num = stack.pop();
            for (int i = 0; i < n; i++) {
                List<Integer> nodes = pathMatrix.get(num);
                if (nodes.contains(destination)) {
                    return true;
                }
                if (!visited.contains(i) && nodes.contains(i)) {
                    stack.push(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }

    private Map<Integer, List<Integer>> createPathMatrix(int n, int[][] edges) {
        Map<Integer, List<Integer>> pathMatrix = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            pathMatrix.put(i, list);
        }
        for (int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            addPath(pathMatrix, e1, e2);
            addPath(pathMatrix, e2, e1);
        }
        return pathMatrix;
    }

    private void addPath(Map<Integer, List<Integer>> pathMatrix, int from, int to) {
        List<Integer> list = pathMatrix.get(from);
        list.add(to);
    }
}