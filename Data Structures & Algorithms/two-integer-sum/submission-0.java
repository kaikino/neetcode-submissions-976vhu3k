class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (hash.containsKey(target - cur)){
                return new int[]{hash.get(target - cur), i};
            } else {
                hash.put(cur, i);
            }
        }
        return null;
    }
}
