class Solution {
    class Pair {
        int node, time;
        public Pair(int ui, int ti) {
            this.node = ui;
            this.time = ti;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.offer(new Pair(k, 0));

        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int time = cur.time;

            for(Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edw = it.time;

                if(time + edw < dist[adjNode]) {
                    dist[adjNode] = time + edw;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == (int)1e9) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
