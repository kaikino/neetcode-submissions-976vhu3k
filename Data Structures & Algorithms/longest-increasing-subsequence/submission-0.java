class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] longests = new int[l];
        int out = 0;
        for (int i = l - 1; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < l; j++) {
                if (nums[i] < nums[j]) {
                    if (longests[j] + 1 > max) {
                        max = longests[j] + 1;
                    }
                }
            }
            longests[i] = max;
            if (max > out) {
                out = max;
            }
        }
        return out;
    }
}
