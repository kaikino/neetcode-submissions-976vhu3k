class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        def explore(i, j):
            if i < len(grid) and i >= 0 and j < len(grid[0]) and j >= 0:
                if not found[i][j] and grid[i][j] == "1":
                    found[i][j] = True;
                    explore(i+1,j)
                    explore(i-1,j)
                    explore(i,j+1)
                    explore(i,j-1)

        out = 0
        found = [[False for i in range(len(grid[0]))] for i in range(len(grid))]
        for i, li in enumerate(grid):
            for j, val in enumerate(li):
                if not found[i][j]:
                    if val == "1":
                        out+=1
                        explore(i, j)
        return out