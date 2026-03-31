class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda a: a[0])
        end = -100000
        out = list()
        for interval in intervals:
            if interval[0] < end:
                if interval[1] < end:
                    out[-1] = interval
                    end = interval[1]
            else:
                out.append(interval)
                end = interval[1]
        return len(intervals)-len(out)