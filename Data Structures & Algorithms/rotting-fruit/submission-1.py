class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        h = len(grid)
        w = len(grid[0])
        pend = set()
        fresh = set()
        x = [-1, 1, 0, 0]
        y = [0, 0, -1, 1]
        for i in range(h):
            for j in range(w):
                if (grid[i][j] == 2):
                    pend.add((i,j))
                elif (grid[i][j] == 1):
                    fresh.add((i,j))
        out = 0
        while pend:
            newpend = set()
            for fruit in pend:
                for k in range(4):
                    ya = fruit[0]+y[k]
                    xa = fruit[1]+x[k]
                    if ya >= 0 and xa >= 0 and ya < h and xa < w and grid[ya][xa] == 1:
                        newpend.add((ya, xa))
                        fresh.remove((ya, xa))
                        grid[ya][xa] = 2
            pend = newpend
            if not pend:
                break

            out += 1
        if fresh:
            return -1
        return out
