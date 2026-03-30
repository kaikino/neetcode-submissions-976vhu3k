class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        int i = 0;
        while (i < l - 2) {
            int j = i+1;
            int k = l-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    out.add(new ArrayList(List.of(nums[i], nums[j], nums[k])));
                    System.out.println(i + " " + j + " " + k);
                    while (nums[j+1] == nums [j]) {
                        j++;
                        if (j == l - 1) {break;}
                    }
                    j++;
                    while (nums[k-1] == nums [k]) {
                        k--;
                        if (k == i) {break;}
                    }
                    k--;
                } else if (sum < 0) {
                    while (nums[j+1] == nums [j]) {
                        j++;
                        if (j == l - 1) {break;}
                    }
                    j++;
                } else {
                    while (nums[k-1] == nums [k]) {
                        k--;
                        if (k == i) {break;}
                    }
                    k--;
                }
            }
            while (nums[i+1] == nums[i]) {
                i++;
                if (i == l - 1) {break;}
            }
            i++;
        }
        return out;
    }
}
