class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put('}','{');
        pairs.put(']','[');
        
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
        System.out.println(stack);
            if (!stack.isEmpty()) {
                if (stack.peek().equals(pairs.get(c))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return (stack.isEmpty());
    }
}
