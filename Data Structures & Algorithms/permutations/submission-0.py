from collections import deque

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.out = []
        self.dive(deque(nums), [])
        return self.out

    def dive(self, rem, seq):
        if (len(rem) == 0):
            self.out.append(seq[:])
            return
        
        for i in range(len(rem)):
            a = rem.popleft()
            seq.append(a)
            self.dive(rem, seq)
            seq.pop()
            rem.append(a)
