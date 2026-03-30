class Solution {

    int count = 0;
    String s;
    public int countSubstrings(String s) {
        this.s = s;
        if (s == null) {
            return 0;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            find(i);
        }
        return count;
    }

    private void find(int ind) {
        int best = 0;

        for (int i = 0; i <= ind; i++) {
            int left = i;
            int right = ind;

            while (s.charAt(left) == s.charAt(right)) {
                if (right - left <= 1) {

                    count++;
                    break;
                }
                left++;
                right--;
            }
        }
    }
}
