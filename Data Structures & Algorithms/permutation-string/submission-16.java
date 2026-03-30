class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1chars = new HashMap<>();
        int total = 0;
        for (char c: s1.toCharArray()) {
            int n = s1chars.getOrDefault(c, 0);
            s1chars.put(c, n + 1);
            if (n == 0) {
                total++;
            }
        }

        int l = 0;
        int r = 0;
        for (; r < s1.length(); r++) {
        System.out.println(s1chars.toString() + ", " + total);
            Integer count = s1chars.get(s2.charAt(r));
            if (count != null) {
                if (count == 0) {
                    total++;
                } else if (count == 1) {
                    total--;
                }
                s1chars.put(s2.charAt(r), count - 1);
            }
            
        }

        while (r < s2.length()) {
            if (total == 0) {
                return true;
            }

            Integer count = s1chars.get(s2.charAt(r));
            if (count != null) {
                if (count == 0) {
                    total++;
                } else if (count == 1) {
                    total--;
                }
                s1chars.put(s2.charAt(r), count - 1);
            }

            count = s1chars.get(s2.charAt(l));
            if (count != null) {
                if (count == 0) {
                    total++;
                } else if (count == -1) {
                    total--;
                }
                s1chars.put(s2.charAt(l), count + 1);
            }

            
            l++;
            r++;
        }

        
        return total == 0;
    }
}
