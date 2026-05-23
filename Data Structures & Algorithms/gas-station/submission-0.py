class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        diff = []
        for i in range(len(gas)):
            diff.append(gas[i] - cost[i])
        hi = -10000
        hidx = 0
        cur = 0
        idx = 0
        w = 0
        for i in range(0, len(gas)*2):
            if w == len(gas):
                break
            cur += diff[i%len(gas)]
            print(f"i: {i}, w: {w} cur: {cur}")
            if cur < 0:
                cur = 0
                idx = (i + 1) % len(gas)
                w = -1
            elif cur > hi:
                hi = cur
                hidx = idx
            w += 1
        accum = 0
        for i in range(0, len(gas)):
            accum += diff[(hidx+i)%len(gas)]
            if accum < 0:
                return -1
        return hidx


