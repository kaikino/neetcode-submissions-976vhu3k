class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> all = new HashSet<Integer>();
        for (int n : nums) {
            all.add(n);
        }
        Map<Integer, Integer> starts = new HashMap<Integer, Integer>();
        for (int n : all) {
            if (!all.contains(n-1)) {
                starts.put(n, 1);
            }
        }
        int max = 0;
        for (int n : starts.keySet()) {
            int count = 1;
            while (all.contains(n+1)) {
                count++;
                n++;
            }
            if (count > max) {max = count;}
        }
        return max;
    }
}
