class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        firstCol = False
        for row in matrix:
            if row[0] == 0:
                firstCol = True
                break
        for row in matrix:
            for element in row:
                if element == 0:
                    row[0] = 0
                    break
        for i in range(1,len(matrix[0])):
            for j in range(len(matrix)):
                if matrix[j][i] == 0:
                    matrix[0][i] = 0
                    break
        print(matrix)
        for i in range(1,len(matrix[0])):
            if (matrix[0][i] == 0):
                for j in range(len(matrix)):
                    matrix[j][i] = 0
        for i in range(len(matrix)):
            if (matrix[i][0] == 0):
                for j in range(len(matrix[0])):
                    matrix[i][j] = 0
        if firstCol:
            for j in range(len(matrix)):
                    matrix[j][0] = 0
