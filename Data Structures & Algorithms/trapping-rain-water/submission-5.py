class Solution:
    def trap(self, height: List[int]) -> int:
        stack = [(0, height[0])]
        out = 0
        for i, h in enumerate(height[1:], start=1):
            prev = 0
            while stack and h >= stack[-1][1]:
                start, cur = stack.pop()
                diff = cur - prev
                out += diff * (i - start - 1)
                prev = cur
            if stack:
                out += (h - prev) * (i - stack[-1][0] - 1)
            if (h > 0):
                stack.append((i, h))
        return out