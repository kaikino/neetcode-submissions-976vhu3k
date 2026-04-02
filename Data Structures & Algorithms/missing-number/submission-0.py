class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        out = 0
        for i in range(len(nums)+1):
            out = out ^ i
        for num in nums:
            out = out ^ num
        return out