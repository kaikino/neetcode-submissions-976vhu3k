class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while (l < r):
            mid = l + (r-l)//2
            print(f"l{l}, r{r}, mid{mid}")
            if target < nums[mid]:
                r = mid - 1
            elif target > nums[mid]:
                l = mid + 1
            else:
                return mid
        if (nums[l] == target):
            return l
        else:
            return -1