class Pair {
    int[] point;
    double dis;
    Pair(int[] point, double dis) {
        this.point = point;
        this.dis = dis;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dis, a.dis));
        double[] origin = {0, 0};
        for(int[] point : points) {
            double x1 = origin[0];
            double x2 = point[0];
            double y1 = origin[1];
            double y2 = point[1];

            double dis1 = x1 - x2;
            double dis2 = y1 - y2;
            double ans = Math.sqrt(dis1 * dis1 + dis2 * dis2);
            pq.add(new Pair(point, ans));

            if(pq.size() > k) {
                pq.poll();
            }
        }
        int n = pq.size();
        int[][] ans = new int[n][2];
        int i = 0;
        while(!pq.isEmpty()) {
            ans[i++] = pq.poll().point;
        }
        return ans;
    }
}
