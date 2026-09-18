class Solution {
    private void dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {
        // If we've already visited this node, stop exploring
        if (visited.contains(node)) {
            return;
        }
        
        // Mark as visited
        visited.add(node);
        
        // Explore all neighbors
        for (int neighbor : adj.get(node)) {
            dfs(neighbor, adj, visited);
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // Step 1: Quick math check. 
        // A valid tree MUST have exactly n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        // Step 2: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 3: Run a simple DFS from node 0 to find all connected nodes
        Set<Integer> visited = new HashSet<>();
        dfs(0, adj, visited);

        // Step 4: If we were able to reach every single node, it's a valid tree!
        return visited.size() == n;
    }
}
