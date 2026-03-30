class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        char chars[] = s.toCharArray();        
        int l = 0;
        int r = 0;
        int max = 0;
        int countMax = 0;
        while (r < chars.length) {
            char c = chars[r];
            int get = count.getOrDefault(c, 0);
            count.put(c, get + 1);
            if (get + 1 > countMax) {
                countMax = get + 1;
            }
                
            while (countMax + k < (r - l + 1)) {
                c = chars[l];
                get = count.getOrDefault(c, 0);
                count.put(c, get - 1);
                l++;
            }
            
            if (r-l+1>= max) {
                max = r - l + 1;
            }
            r++;
        }
        return max;
    }
}
