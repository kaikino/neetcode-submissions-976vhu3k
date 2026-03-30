class Solution {
    public int rob(int[] nums) {
        return Math.max(rob(nums, true), rob(nums, false));
    }
    private int rob(int[] nums, boolean h) {
        // [0] if no rob, [1] = 1: robbed
        int[][] maxes = new int[nums.length][2];

        if (h) {
            if (maxes.length == 1) {
                return nums[0];
            }
            maxes[0][0] = 0;
            maxes[0][1] = nums[0];
            for (int i = 1; i < nums.length - 1;  i++) {
                if (i > 2) {
                    maxes[i][1] = Math.max(maxes[i-1][0] + nums[i], maxes[i-2][0] + nums[i]);
                } else {
                    maxes[i][1] = maxes[i-1][0] + nums[i];
                }
                maxes[i][0] = maxes[i-1][1];
            }
            return Math.max(maxes[nums.length-2][0], maxes[nums.length-2][1]);
        } else {
            if (maxes.length == 1) {
                return nums[0];
            }
            maxes[1][0] = 0;
            maxes[1][1] = nums[1];
            for (int i = 2; i < nums.length;  i++) {
                if (i > 3) {
                    maxes[i][1] = Math.max(maxes[i-1][0] + nums[i], maxes[i-2][0] + nums[i]);
                } else {
                    maxes[i][1] = maxes[i-1][0] + nums[i];
                }
                maxes[i][0] = maxes[i-1][1];
            }
            return Math.max(maxes[nums.length-1][0], maxes[nums.length-1][1]);
        }
    }
}
