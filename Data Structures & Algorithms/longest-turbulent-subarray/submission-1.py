class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        a = 1
        b = 1
        out = 1
        for i in range(len(arr)-1):
            even = (i % 2) == 0
            bigger = arr[i] > arr[i+1]
            smaller = arr[i] < arr[i+1]
            if (even):
                if (smaller):
                    a += 1
                    b = 1
                elif (bigger):
                    a = 1
                    b += 1
                else:
                    a = 1
                    b = 1
            else:
                if (bigger):
                    a += 1
                    b = 1
                elif (smaller):
                    a = 1
                    b += 1
                else:
                    a = 1
                    b = 1
            out = max(out, a, b)
        return out

