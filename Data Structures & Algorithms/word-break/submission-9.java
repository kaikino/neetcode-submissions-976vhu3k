class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Integer> lens = new HashMap<>();
        for (String w: wordDict) {
            lens.put(w, w.length());
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[dp.length-1] = true;

        for (int i = dp.length - 2; i >= 0; i--) {
            for (String w: wordDict) {
                if (i + w.length() <= s.length() && 
                    w.equals(s.substring(i, i+w.length()))) {
                    if (dp[i+w.length()]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
