class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> remToIdx = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int r = target - numbers[i];
            if (remToIdx.containsKey(r)) {
                int[] out = {remToIdx.get(r), i + 1};
                return out;
            } else {
                remToIdx.put(numbers[i], i + 1);
            }
        }
        return null;
    }
}
