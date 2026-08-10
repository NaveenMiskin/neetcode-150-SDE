class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int n = intervals.length;

        int idx = 0;
        int[][] nonOverlap = new int[n][2];

        nonOverlap[0] = intervals[0];
        for(int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start <= nonOverlap[idx][1]) {
                nonOverlap[idx][1] = Math.max(nonOverlap[idx][1], end);
            } else {
                idx++;
                nonOverlap[idx] = intervals[i];
            }
        }
        return Arrays.copyOf(nonOverlap, idx + 1);
    }
}
