class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> list = new HashMap<>();
        for (int n : nums) {
            list.put(n, true);
        }
        return list.keySet().size() != nums.length;
    }
}