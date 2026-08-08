class Solution:
    def solve(self, board: List[List[str]]) -> None:
        w = len(board[0])
        h = len(board)
        def dfs(i, j):
            print(f"{i}, {j}")
            if (i >= 0 and i < h and j >= 0 and j < w and board[i][j] == 'O'):
                board[i][j] = '.'
                dfs(i-1,j)
                dfs(i+1,j)
                dfs(i,j-1)
                dfs(i,j+1)
        for k in range(w):
            if (board[0][k] == 'O'):
                dfs(0,k)
            if (board[h-1][k] == 'O'):
                dfs(h-1,k)
        for k in range(1,h-1):
            if (board[k][0] == 'O'):
                dfs(k,0)
            if (board[k][w-1] == 'O'):
                dfs(k, w-1)

        for y in range(h):
            for x in range(w):
                if (board[y][x] == '.'):
                    board[y][x] = 'O'
                else:
                    board[y][x] = 'X'

        