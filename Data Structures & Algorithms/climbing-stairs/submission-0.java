class Solution {
    public int climbStairs(int n) {
        int twos = 0;
        int ones = 1;
        for (int i = 1; i < n; i++) {
            int newOnes = ones + twos;
            twos = ones;
            ones = newOnes;
        }
        return twos + ones;
    }
}
