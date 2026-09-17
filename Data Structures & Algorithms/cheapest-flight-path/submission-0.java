class Solution {
    class Pair {
        int first;
        int second;
        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    class Tuple {
        int first;
        int second;
        int third;

        public Tuple(int f, int s, int t) {
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u).add(new Pair(v, cost));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);

        dist[src] = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()) {
            Tuple cur = q.poll();
            int stops = cur.first;
            int node = cur.second;
            int cost = cur.third;

            if(stops > k) continue;
            for(Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edw = it.second;

                if(cost + edw < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edw;
                    q.add(new Tuple(stops + 1, adjNode, cost + edw));
                }
            }
        }

        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}
