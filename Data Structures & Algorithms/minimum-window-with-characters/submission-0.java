class Solution {
    public String minWindow(String s, String t) {
        char[] chars = t.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        int count = 0;
        for (char c: chars) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            count++;
        }
        int l = 0;
        int r = 0;
        String bestString = "";

        int x = countMap.getOrDefault(s.charAt(0), -1001);
        if (x > 0) {
            count--;
        }
        countMap.put(s.charAt(0), x-1);

        while (r < s.length()) {
            if (count > 0) {
                if (r == s.length() - 1) {break;}
                r++;
                int n = countMap.getOrDefault(s.charAt(r), -1001);
                if (n > 0) {
                    count--;
                }
                countMap.put(s.charAt(r), n-1);
            } else {
                String sub = s.substring(l, r + 1);
                if (bestString.equals("") || bestString.length() > sub.length()) {
                    bestString = sub;
                }
                int n = countMap.get(s.charAt(l));
                if (n >= 0) {
                    count++;
                }
                countMap.put(s.charAt(l), n+1);
                l++;
            }
        }
        return bestString;
    }
}
