class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> letters = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letters.containsKey(letter) && letters.get(letter) >= start) {
                start = letters.get(letter) + 1;
            } else {
                if (i - start + 1 > max) {
                    max = i - start + 1;
                }
            }
            letters.put(letter, i);
        }
        return max;
     }
}
