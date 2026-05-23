
from collections import deque
inf = 2147483647

dRow = [ -1, 0, 1, 0]
dCol = [ 0, 1, 0, -1]

class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        self.grid = grid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != -1:
                    grid[i][j] = self.bfs(i,j)

    def bfs(self, x, y):
        vis = {(x,y)}
        q = deque([(x,y,0)])

        while q:
            i,j,dist = q.popleft()
            if self.grid[i][j] == 0:
                return dist
            for k in range(4):
                m = i + dRow[k]
                n = j + dCol[k]
                if (m != -1 and n != -1 and m < len(self.grid) and n < len(self.grid[0]) and self.grid[m][n] != -1 and (m,n) not in vis):
                    q.append((m, n, dist + 1))
                    vis.add((m,n))
        return inf
            



