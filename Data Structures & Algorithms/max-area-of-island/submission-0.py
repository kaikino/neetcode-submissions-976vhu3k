class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        self.seen = [[False for _ in range(0, len(grid[0]))] for _ in range(0, len(grid))]
        self.grid = grid
        out = 0
        for i in range(len(grid)*len(grid[0])):
            out = max(self.dfs(i//len(grid[0]), i%len(grid[0])), out)
        return out

    def dfs(self, i, j) -> int:
        if (i == len(self.grid)
         or j == len(self.grid[0])
         or i == -1
         or j == -1
         or self.grid[i][j] == 0
         or self.seen[i][j]):
            return 0

        self.seen[i][j] = True
        return 1 + self.dfs(i+1,j) + self.dfs(i,j+1) + self.dfs(i-1,j) + self.dfs(i,j-1)
        