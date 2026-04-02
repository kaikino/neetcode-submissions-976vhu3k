class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        out = 0
        i = 1
        for num in nums:
            out = out ^ num ^ i
            i += 1
        return out