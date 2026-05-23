class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        diff = []
        idx = 0
        tot = 0
        cur = 0
        for i in range(0, n):
            cur += gas[i] - cost[i]
            tot += gas[i] - cost[i]
            if cur < 0:
                cur = 0
                idx = i + 1

        return idx if tot >= 0 else -1


