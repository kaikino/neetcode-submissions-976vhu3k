class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        tot = 0
        for num in nums:
            tot += num
        if tot % 2 == 1:
            return False
        tot /= 2
        nums.sort()
        rems = {tot}
        for i in range(len(nums)-1, -1, -1):
            newrems = set()
            for num in rems:
                if num == nums[i]:
                    return True
                if num > nums[i]:
                    newrems.add(num-nums[i])
            rems.update(newrems)
        return False