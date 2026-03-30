class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = 1;
        int area = 0;

        while (r < height.length) {
            if (height[r] >= height[l]) {
                int left = height[l];
                l++;
                while (l < r) {
                    area += left - height[l];
                    l++;
                }
            }
            r++;
        }

        int r2 = height.length - 1;
        int l2 = height.length - 2;

        while (l2 >= l) {
            if (height[l2] >= height[r2]) {
                int right = height[r2];
                r2--;
                while (l2 < r2) {
                    area += right - height[r2];
                    r2--;
                }
            }
            l2--;
        }



        return area;
    }
}
