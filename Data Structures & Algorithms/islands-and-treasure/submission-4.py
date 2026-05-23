
from collections import deque
inf = 2147483647

dRow = [ -1, 0, 1, 0]
dCol = [ 0, 1, 0, -1]

class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        q = deque()
        vis = set()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    q.append((i,j,0))
                    vis.add((i,j))

        while q:
            i,j,dist = q.popleft()
            for k in range(4):
                m = i + dRow[k]
                n = j + dCol[k]
                if (m != -1 and n != -1 and m < len(grid) and n < len(grid[0]) and grid[m][n] != -1 and (m,n) not in vis):
                    q.append((m, n, dist + 1))
                    vis.add((m,n))
                    grid[m][n] = dist + 1

