"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        starts = [interval.start for interval in intervals]
        ends = [interval.end for interval in intervals]
        starts.sort()
        ends.sort()
        s = 0
        e = 0
        out = 0
        count = 0
        while e < len(intervals) and s < len(intervals):
            if starts[s] < ends[e]:
                s += 1
                count += 1
                out = max(out, count)
            else:
                e += 1
                count -= 1
        return out