class Solution {
    int max = 0;
    String out;
    String s;
    public String longestPalindrome(String s) {
        this.s = s;
        if (s == null) {
            return "";
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            find(i);
            if (max >= i) {
                return out;
            }
        }
        return out;
    }

    private void find(int ind) {
        int best = 0;
        System.out.println("------INDEX: " + ind);
        for (int i = 0; i <= ind; i++) {
            int left = i;
            int right = ind;
            System.out.println(left + ", " + right);
            while (s.charAt(left) == s.charAt(right)) {
                if (right - left <= 1) {
                    if (ind - i + 1 > max) {
                        out = s.substring(i, ind + 1);
                        max = ind + 1 - i;
                    }
                    break;
                }
                left++;
                right--;
            }
        }
    }
}
