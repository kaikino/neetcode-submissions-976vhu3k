class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2 ;
            if (nums[mid] > nums[l]) {
                if (nums[mid] > nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else if (nums[mid] == nums[l]) {
                return Math.min(nums[l], nums[r]);
            } else {
                r = mid;
            }
            System.out.println(mid);
        }
        return nums[r];
    }
}
