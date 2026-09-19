class Solution {
    private void dfs(int node, List<List<Integer>> adj, Set<Integer> vis) {
        if(vis.contains(node)) return;

        vis.add(node);

        for(int it : adj.get(node)) {
            dfs(it, adj, vis);
        }
    }
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) return false;
        
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

        Set<Integer> vis = new HashSet<>();
        dfs(0, adj, vis);

        return vis.size() == n;
    }
}
