class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid;
        while (l < r - 1) {
            mid = (l + r)/2;
            System.out.println(r);
            if (target == nums[l]) {
                return l;
            }
            if (target == nums[r]) {
                return r;
            }
            if (target < nums[mid]) {
                if (nums[l] < target) {
                    r = mid;
                } else {
                    if (nums[l] < nums[mid]) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
            } else {
                if (target < nums[r]) {
                    l = mid;
                } else {
                    if (nums[mid] < nums[r]) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
            }
        }
        if (target == nums[l]) {
            return l;
        }
        if (target == nums[r]) {
            return r;
        }
        return -1;
    }
}
