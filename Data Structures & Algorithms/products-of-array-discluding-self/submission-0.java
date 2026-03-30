class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prodLeft = new int[l];
        prodLeft[0] = nums[0];
        for (int i = 1; i < l; i++) {
            prodLeft[i] = prodLeft[i-1] * nums[i];
        }

        int[] prodRight = new int[l];
        prodRight[l-1] = nums[l-1];
        for (int i = l-2; i >= 0; i--) {
            prodRight[i] = prodRight[i+1] * nums[i];
        }
        int[] out = new int[l];
        out[0] = prodRight[1];
        out[l-1] = prodLeft[l-2];
        for (int i = 1; i < l-1; i++) {
            out[i] = prodLeft[i-1] * prodRight[i+1];
        }
        return out;
    }
}  
