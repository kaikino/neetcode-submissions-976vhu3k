class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        w = len(matrix[0])
        l = 0
        r = w * len(matrix) - 1
        while (l < r):
            mid = l + (r-l)//2
            print(f"i{mid//w}, j{mid%w}")
            if target < matrix[mid//w][mid%w]:
                r = mid - 1
            elif target > matrix[mid//w][mid%w]:
                l = mid + 1
            else:
                return True
        return (matrix[l//w][l%w] == target)
