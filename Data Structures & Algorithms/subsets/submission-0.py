class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        path = []
        out = [[]]
        def dive(idx):
            for i in range(idx + 1, len(nums)):
                path.append(nums[i])
                out.append(path[:])
                dive(i)
                path.pop()
        dive(-1)
        return out