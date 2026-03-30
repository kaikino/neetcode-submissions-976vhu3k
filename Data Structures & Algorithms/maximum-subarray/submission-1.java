class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int i = 0;
        while (nums[i] < 0) {
            if (nums[i] > max) {
                max = nums[i];
            }
            i++;
            if (i == nums.length) {
                return max;
            }
        }
        for (; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            } else if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
