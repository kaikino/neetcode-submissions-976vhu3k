class Solution:
    def jump(self, nums: List[int]) -> int:
        out = 0
        idx = 0
        while idx < len(nums) - 1:
            hi = 0
            jam = 0
            for jamt in range(1, nums[idx] + 1):
                if jamt + idx >= len(nums) - 1:
                    return out + 1
                if jamt + nums[jamt + idx] >= hi:
                    hi = jamt + nums[jamt + idx]
                    jam = jamt
            idx += jam
            out += 1
        return out