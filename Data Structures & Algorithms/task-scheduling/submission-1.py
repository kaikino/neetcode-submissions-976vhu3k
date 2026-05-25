from collections import Counter, deque
import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:# Use Counter to get frequencies
        counts = Counter(tasks)
        rem = [-count for count in counts.values()]
        heapq.heapify(rem)

        time = 0
        q = deque()
        while rem or q:
            if not rem:
                time = q[0][1]
            else:
                count = heapq.heappop(rem)
                if count < -1:
                    q.append((count+1, time+n+1))
                time += 1
            while q:
                if q[0][1] == time:
                    heapq.heappush(rem, q.popleft()[0])
                else:
                    break
        return time
