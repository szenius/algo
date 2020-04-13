/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        sort(intervals);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                intervals.set(i - 1, mergeIntervals(intervals, i - 1, i));
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
    
    private void sort(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval s1, Interval s2) {
                // notice the cast to (Integer) to invoke compareTo
                return ((Integer)s1.start).compareTo(s2.start);
            }
        });
    }
    
    private Interval mergeIntervals(List<Interval> intervals, int i, int j) {
        Interval first = intervals.get(i);
        Interval second = intervals.get(j);
        return new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end));
    }
}