class Solution {
    String s;

    public int numDecodings(String s) {
        this.s = s;
        // [0] = 2nd digit, [1] = 1st digit
        int[][] nums = new int[s.length()][2];
        if (numAt(0) == 0) {
            return 0;
        }

        nums[0][0] = 0;
        nums[0][1] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (numAt(i-1) == 1 || numAt(i-1) == 2 && numAt(i) <= 6) {
                nums[i][0] = nums[i-1][1];
            }
            if (numAt(i) != 0) {
                nums[i][1] = nums[i-1][1] + nums[i-1][0];
            }
        }
        return nums[s.length()-1][0] + nums[s.length()-1][1];
    }

    private int numAt(int n) {
        return s.charAt(n)-'0';
    }
}
