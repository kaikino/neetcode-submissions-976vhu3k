class Solution:
    def countBits(self, n: int) -> List[int]:
        out = [0]
        base = 1
        for i in range(1, n+1):
            if i == base << 1:
                out.append(1)
                base = base << 1
            else:
                out.append(1+out[i % base])
        return out
