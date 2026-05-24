class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        self.candidates = candidates
        self.candidates.sort()
        self.out = []
        last = -1
        for i, n in enumerate(candidates):
            if n == last:
                continue
            last = n
            if n > target:
                break
            self.dive(i, target, [])
        return self.out

    def dive(self, idx, rem, seq):
        rem -= self.candidates[idx]
        if rem < 0:
            return True
        seq.append(self.candidates[idx])
        if rem == 0:
            self.out.append(seq[:])
            seq.pop()
            return True
        last = -1
        for i in range(idx + 1, len(self.candidates)):
            if self.candidates[i] == last:
                continue
            last = self.candidates[i]
            if self.dive(i, rem, seq):
                break
        seq.pop()
        return False
            