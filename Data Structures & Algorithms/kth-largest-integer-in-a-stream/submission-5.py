import heapq

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        heapq.heapify(nums)
        self.hello = nums
        self.k = k
        while len(self.hello) > k:
            heapq.heappop(self.hello)
        print(self.hello)

    def add(self, val: int) -> int:
        if len(self.hello) < self.k:
            heapq.heappush(self.hello, val)
            return self.hello[0]
        if val <= self.hello[0]:
            print(self.hello)

            return self.hello[0]
        else:
            heapq.heappop(self.hello)
            heapq.heappush(self.hello, val)
            print(self.hello)
            return self.hello[0]
        
