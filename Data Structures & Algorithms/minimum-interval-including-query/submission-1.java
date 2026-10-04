class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for(int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);

            }
            return Integer.compare(a[1], b[1]);
        });

        int[] result = new int[m];
        int idx = 0;

        for(int i = 0; i < m; i++) {
            int queryVal = sortedQueries[i][0];
            int orginalIdx = sortedQueries[i][1];

            while(idx < intervals.length && intervals[idx][0] <= queryVal) {
                int left = intervals[idx][0];
                int right = intervals[idx][1];
                int length = right - left + 1;
                min.add(new int[]{length, right});
                idx++;
            }

            while(!min.isEmpty() && min.peek()[1] < queryVal) {
                min.poll();
            }

            result[orginalIdx] = min.isEmpty() ? -1 : min.peek()[0];
        }
        return result;
    }
}
