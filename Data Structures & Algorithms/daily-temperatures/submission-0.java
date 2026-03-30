class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                int temp = temperatures[i];
                int idx = stack.peek();
                if (temp > temperatures[idx]) {
                    stack.pop();
                    out[idx] = i - idx;
                } else {
                    break;
                }
            }

            stack.push(i);
            
        }
        return out;
    }
}
