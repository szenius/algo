'''
https://leetcode.com/problems/merge-intervals/
'''


def merge_intervals(intervals):
    if len(intervals) <= 1:
        return intervals

    intervals.sort()
    result = [intervals[0]]
    i = 1
    while i < len(intervals):
        curr = intervals[i]
        if result[-1][1] < curr[0]:
            result.append(curr)
        else:
            result[-1][1] = max(curr[1], result[-1][1])
        i += 1
    return result


print(merge_intervals([[1, 3], [2, 6], [8, 10], [15, 18]]))
