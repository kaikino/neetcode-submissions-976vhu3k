class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> topK = new PriorityQueue<>((a,b) -> b - a);

        int l = 0;
        
        while (l < k) {
            topK.add(nums[l]);
            l++;
        }

        HashMap<Integer, Integer> toRemove = new HashMap<>();
        int[] out = new int[nums.length - k + 1];
            
        out[0] = topK.peek();
        for (; l < nums.length; l++) {
            topK.add(nums[l]);
            toRemove.put(nums[l-k], toRemove.getOrDefault(nums[l-k], 0) + 1);
            while (true) {
                int max = topK.peek();
                if (toRemove.get(max) != null && toRemove.get(max) > 0) {
                    toRemove.put(max, toRemove.get(max) - 1);
                    topK.remove();
                } else {
                    out[l-k+1] = max;
                    break;
                }
            }
        }
        return out;
    }
}
