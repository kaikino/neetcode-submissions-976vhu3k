class Solution {
    HashMap<Integer, Integer> some = new HashMap<>();
    int[] coins;
    int amount;
    int best = -1;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins = coins;
        this.amount = amount;
        return dfs(0);
    }

    private int dfs(int sum) {
        if (sum == amount) {
        System.out.println("some.toString()");
            return 0;
        }
        if (some.containsKey(amount - sum)) {
            return some.get(amount - sum);
        }
        int res = -1;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - sum >= coins[i]) {
                int result = dfs(sum + coins[i]);
                if (result != -1) {
                    if (res == -1 || res > result + 1) {
                        res = result + 1;
                    }
                }
            }

        }
        some.put(amount - sum, res);
        return res;
    }
}
