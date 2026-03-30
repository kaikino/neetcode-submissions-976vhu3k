class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int l = 0;
        int r = n;
        int t = 0;
        int b = n;

        while (l < r) {
            int i = 0;
            while (i < r - l) {
                int temp = matrix[l+i][t];
                matrix[l+i][t] = matrix[r][t+i];
                matrix[r][t+i] = matrix[r-i][b];
                matrix[r-i][b] = matrix[l][b-i];
                matrix[l][b-i] = temp;
                i++;
            }
            l++;
            r--;
            t++;
            b--;
        }
    }
    
}
