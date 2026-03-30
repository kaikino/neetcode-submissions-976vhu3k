class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> b[0]-a[0]);

        int count = 1;
        double prev = (double)(target - cars[0][0])/cars[0][1];
        // int prev = (target - cars[0][0] + cars[0][1] - 1)/cars[0][1];
        for (int i = 1; i < cars.length; i++) {
            double cur = (double)(target - cars[i][0])/cars[i][1];
            // int cur = (target - cars[i][0] + cars[i][1] - 1)/cars[i][1];
            if (cur > prev) {
                count++;
                prev = cur;
            }
        }
        return count;
    }
}
