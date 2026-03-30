class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int neg, pos;
        int seen = nums[0];
        if (nums[0] < 0) {
            neg = nums[0];
            pos = 0;
        } else {
            neg = 0;
            pos = nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seen) {
                seen = nums[i];
            }
            if (nums[i] < 0) {
                int temp = neg;
                if (pos == 0) {
                    neg = nums[i];
                } else {
                    neg = pos * nums[i];
                }
                if (temp == 0) {
                    pos = 0;
                } else {
                    pos = temp * nums[i];
                }
            } else {
                if (pos == 0) {
                    pos = nums[i];
                } else {
                    pos *= nums[i];
                }
                neg *= nums[i];
            }
            if (pos > max) {
                max = pos;
            }
        }
        if (max == 0) {
            return seen;
        }
        return max;
    }
}
