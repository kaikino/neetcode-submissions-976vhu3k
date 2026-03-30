class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if len(intervals) == 0:
            return [newInterval]
        start = newInterval[0]
        end = newInterval[1]
        i=0
        for i, interval in enumerate(intervals):
            if start <= interval[1]:
                if end < interval[0]:
                    intervals.insert(i, newInterval)
                    return intervals
                interval[0] = min(interval[0], start)
                if end <= interval[1]:
                    return intervals
                for interval in intervals[i+1:]:
                    print(interval)
                    if end >= interval[0]:
                        print(interval)
                        # remove
                        if end <= interval[1]:
                            intervals[i][1] = interval[1]
                            intervals.pop(i+1)
                            return intervals
                        intervals.pop(i+1)
                    else:
                        break
                intervals[i][1] = end
                return intervals
        intervals.append(newInterval)
        return intervals