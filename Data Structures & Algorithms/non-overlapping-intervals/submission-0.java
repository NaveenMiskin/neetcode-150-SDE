class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < n; i++) {
            int curSt = intervals[i][0];
            int curEd = intervals[i][1];

            if(curSt < prevEnd) {
                count++;
                prevEnd = Math.min(prevEnd, curEd);
            } else {
                prevEnd = curEd;
            }
        }
        return count;
    }
}
