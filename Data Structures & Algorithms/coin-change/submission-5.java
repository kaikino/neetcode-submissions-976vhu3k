class Solution {
    HashMap<Integer, Integer> some = new HashMap<>();
    int[] coins;
    int amount;
    int best = -1;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins = coins;
        this.amount = amount;
        dfs(0, 0);
        return best;
    }

    private boolean dfs(int sum, int count) {
        if (some.containsKey(sum)) {
            if (some.get(sum) > count) {
                some.put(sum, count);
            } else {
                return false;
            }
        } else {
            some.put(sum, count);
        }
        if (sum == amount) {
            if (best == -1) {
                best = count;
            } else if (count < best) {
                best = count;
            }
            return true;
        }
        if (sum > amount) {
            return false;
        }

        if (some.containsKey(amount - sum)) {
            int result = count + some.get(amount - sum);
            if (best == -1) {
                best = result;
            } else if (result < best) {
                best = result;
            }
            return true;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            dfs(sum + coins[i], count + 1);
        }
        return false;
    }
}
