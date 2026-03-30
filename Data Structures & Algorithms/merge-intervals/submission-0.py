class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda a: a[0])
        start = intervals[0][0]
        end = intervals[0][1]
        out = list()
        for interval in intervals[1:]:
            if end < interval[0]:
                out.append([start,end])
                start = interval[0]
                end = interval[1]
            else:
                end = max(interval[1], end)
        out.append([start,end])
        return out
