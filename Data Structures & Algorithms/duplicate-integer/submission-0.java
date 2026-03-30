class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (list.contains(n)) {
                return true;
            } else {
                list.add(n);
            }
        }
        return false;
    }
}