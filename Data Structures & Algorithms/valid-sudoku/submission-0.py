class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        columns = [set() for _ in range(9)]
        squares = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if (num == '.'):
                    continue
                if (num in rows[i]):
                    print("row")
                    print(rows)
                    return False
                else:
                    rows[i].add(num)
                if (num in columns[j]):
                    print("column")
                    print(columns)
                    return False
                else:
                    columns[j].add(num)
                if (num in squares[(i//3)*3+j//3]):
                    print("squares")
                    print(squares)
                    return False
                else:
                    squares[(i//3)*3+j//3].add(num)
        return True