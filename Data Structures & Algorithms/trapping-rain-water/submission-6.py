class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        lmax = 0 # maxes must be smaller than smth we've seen
        rmax = 0
        rain = 0
        while (l < r):
            if (height[l] < height[r]):
                if (height[l] > lmax):
                    lmax = height[l]
                else:
                    rain += lmax - height[l]
                l += 1
            else:
                if (height[r] > rmax):
                    rmax = height[r]
                else:
                    rain += rmax - height[r]
                r -= 1
        return rain
