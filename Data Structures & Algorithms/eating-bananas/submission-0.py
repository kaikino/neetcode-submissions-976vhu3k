class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1
        r = max(piles)
        while (l < r):
            mid = l + (r-l)//2
            hrs = 0
            print(f"l{l}, r{r}")
            for p in piles:
                hrs += (p-1)//mid + 1
            if hrs > h:
                l = mid + 1
            elif hrs <= h:
                r = mid
        return r