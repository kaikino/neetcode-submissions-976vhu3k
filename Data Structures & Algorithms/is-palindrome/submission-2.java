class Solution {
    public boolean isPalindrome(String s) {
        int ac = 0;
        int bc = s.length() - 1;
        s = s.toLowerCase();
        while (ac < bc) {
            char a = s.charAt(ac);
            char b = s.charAt(bc);
            if (('0' <= a && a <= '9') || ('a' <= a && a <= 'z')) {
                if (('0' <= b && b <= '9') || ('a' <= b && b <= 'z')) {
                    if (a != b) {
                        return false;
                    }
                    ac++;
                    bc--;
                } else {
                    bc--;
                }
            } else {
                ac++;
            }
        }
        return true;
    }
}
