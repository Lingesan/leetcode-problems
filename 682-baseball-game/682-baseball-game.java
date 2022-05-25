class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(String op:ops){
            switch(op){
                case "C": stack.pop();
                    break;
                case "D": int val = stack.peek();
                    stack.push(2 * val);
                    break;
                case "+": stack.push(stack.peek() + stack.get(1));
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        return stack.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}