class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        h = len(heights)
        w = len(heights[0])

        reach = [[(c==0 or r==0, c==w-1 or r==h-1) for c in range(w)] for r in range(h)]

        def explore(val, r,c, explored):
            for i in range(4):
                nextr = r + (1 if i <= 1 else 0) * (-1 if i == 0 else 1)
                nextc = c + (1 if i > 1 else 0) * (-1 if i == 2 else 1)
                if ((nextr, nextc) not in explored and nextr >= 0 and nextr < h and nextc >= 0 and nextc < w and heights[nextr][nextc] >= heights[r][c]):
                    newp = reach[nextr][nextc][0] or val[0]
                    newa = reach[nextr][nextc][1] or val[1]
                    if (newp != reach[nextr][nextc][0] or newa != reach[nextr][nextc][1]):
                        reach[nextr][nextc]=(newp, newa)
                        explored.add((r,c))
                        explore((newp, newa), nextr, nextc, explored)
                        explored.remove((r,c))

        for i in range(h):
            explore(reach[i][0], i, 0, {(i,0)})
            explore(reach[i][w-1], i, w-1, {(i,w-1)})
        for i in range(1,w-1):
            explore(reach[0][i], 0, i,{(0,i)})
            explore(reach[h-1][i], h-1, i, {(h-1,i)})

        out=list()
        for r, row in enumerate(reach):
            for c, e in enumerate(row):
                if e[0] and e[1]:
                    out.append([r,c])
        return out
    