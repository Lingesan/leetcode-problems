class Solution {
    public int longestValidParentheses(String s) {
        Map<Integer, Integer> sizeIndexMap = new HashMap<>();
        LinkedList<Group> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char charz = s.charAt(i);
            Group top = stack.peek();
            if (top != null && top.value == '(' && charz == ')') {
                stack.pop();
                int key = stack.size();
                int currentIndex = stack.peek() != null ? stack.peek().index : -1;
                int newValue = i - currentIndex;
                sizeIndexMap.put(key, newValue);
            } else {
                Group group = new Group(charz, i);
                stack.push(group);
            }
        }
        return sizeIndexMap.values().stream().max(Integer::compareTo).orElse(0);
    }

    static class Group {
        public Group(char value, int index) {
            this.value = value;
            this.index = index;
        }

        char value;
        int index;
    }
}