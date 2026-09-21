class Solution {
    class Pair {
        int node, cost;
        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Pair(0, 0));

        boolean[] vis = new boolean[n];
        int totalcost = 0;
        int connectedComp = 0;

        while(connectedComp < n) {
            Pair cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if(vis[node]) continue;

            vis[node] = true;
            totalcost += cost;
            connectedComp++;

            for(int nextNode = 0; nextNode < n; nextNode++) {
                if(!vis[nextNode]) {
                    int nextCost = Math.abs(points[nextNode][0] - points[node][0]) + 
                                Math.abs(points[nextNode][1] - points[node][1]);
                    
                    pq.offer(new Pair(nextNode, nextCost));
                }
            }
        }
        return totalcost;
    }
}
