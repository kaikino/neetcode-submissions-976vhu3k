class Solution:
    def reverseBits(self, n: int) -> int:
        for i in range(16):
            small = 1 if n & 1 << i > 0 else 0
            big = 1 if n & 1 << (31 - i) > 0 else 0
            n = n & ~(1 << (31 - i) | 1 << i)
            n = (small << (31 - i) | big << i) | n
        return n