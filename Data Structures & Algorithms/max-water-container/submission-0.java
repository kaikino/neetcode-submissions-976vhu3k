class Solution {
    public int maxArea(int[] heights) {
        int l = heights.length;
        int a = 0;
        int b = l-1;
        int max = area(heights, a, b);
        while (a < b) {
            if (heights[a] < heights[b]) {
                a++;
            } else {
                b--;
            }
            if (area(heights, a, b) > max) {
                max = area(heights, a, b);
            }
        }
        return max;
    }

    private int area(int[] heights, int a, int b) {
        if (heights[a] > heights[b]) {return heights[b] * (b-a);}
        return (heights[a] * (b-a));
    }
}
