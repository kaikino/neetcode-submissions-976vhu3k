class Solution {
    public int rob(int[] nums) {
        // [0] if no rob, [1] = 1: robbed
        int[][] maxes = new int[nums.length][2];

        maxes[0][0] = 0;
        maxes[0][1] = nums[0];
        for (int i = 1; i < nums.length;  i++) {
            if (i > 2) {
                maxes[i][1] = Math.max(maxes[i-1][0] + nums[i], maxes[i-2][0] + nums[i]);
            } else {
                maxes[i][1] = maxes[i-1][0] + nums[i];
            }
            maxes[i][0] = maxes[i-1][1];
            System.out.println("0: " +  maxes[i][0] + "\t\t 1: "+  maxes[i][1]);
        }
        return Math.max(maxes[nums.length-1][0], maxes[nums.length-1][1]);
    }
}
