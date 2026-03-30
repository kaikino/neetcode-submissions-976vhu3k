class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        if (nums.length == 1) {
            return true;
        }
        while (i < nums.length) {
            int max = 0;
            int next = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) {
                    return true;
                }
                if (j + nums[i+j] > max) {
                    max = j + nums[i+j];
                    next = i+j;
                }
            }
            if (max == 0) {
                return false;
            }
            i = next;
        }
        return true;
    }
}
