class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        out = set()
        nums.sort()
        for i in range(2**len(nums)):
            res = []
            mask = 1
            for j in range(len(nums)):
                if mask > i:
                    break
                if i & mask:
                    res.append(nums[j])
                mask = mask << 1
            out.add(tuple(res))
        return list(out)
