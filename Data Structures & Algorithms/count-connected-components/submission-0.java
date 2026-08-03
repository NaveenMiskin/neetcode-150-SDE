class Solution {
    public void dfs(int idx, boolean[] vis, List<List<Integer>> adj) {
        vis[idx] = true;
        for(int it : adj.get(idx)) {
            if(!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                components++;
                dfs(i, visited, adj);
            }
        }
        return components;
    }
}
