class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        def go(cur: int, ind: int, out: List[int]):
            for i in range(ind, len(nums)):
                n = nums[i]
                if n + cur == target:
                    out.append(n)
                    final.append(out[:])
                    out.pop()
                elif n + cur < target:
                    out.append(n)
                    go(n + cur, i, out[:])
                    out.pop()
        final = []
        go(0, 0, [])
        return final

