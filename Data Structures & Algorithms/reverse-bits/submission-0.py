class Solution:
    def reverseBits(self, n: int) -> int:
        for i in range(16):
            small = 1 if n & 1 << i > 0 else 0
            big = 1 if n & 1 << (31 - i) > 0 else 0
            print(f"{small}, {big}")
            n = n & ~(1 << (31 - i) | 1 << i)
            print(n)
            n = (small << (31 - i) | big << i) | n
            print(n)
            print("\n")
        return n