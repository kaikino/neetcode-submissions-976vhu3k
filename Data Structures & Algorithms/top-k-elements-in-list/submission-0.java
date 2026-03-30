class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) {
            minHeap.add(key);
        }
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i]=minHeap.remove();
        }
        return out;
    }
}
