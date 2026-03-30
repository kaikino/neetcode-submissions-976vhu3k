class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, y = 0, x = 0;
        List<Integer> out = new ArrayList<>();
        out.add(matrix[0][0]);
        while (t <= b || l <= r) {
            while (x < r) {
                x++;
                out.add(matrix[y][x]);
            }
            t++;
            if (t > b) {break;}
            while (y < b) {
                y++;
                out.add(matrix[y][x]);
            }
            r--;
            if (l > r) {break;}
            while (x > l) {
                x--;
                out.add(matrix[y][x]);
            }
            b--;
            if (t > b) {break;}
            while (y > t) {
                y--;
                out.add(matrix[y][x]);
            }
            l++;
            if (l > r) {break;}
        }
        return out;
    }
}
