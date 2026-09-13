class Solution {
    int[] parent;

    private int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    private void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if(rootU != rootV) {
            parent[rootU] = rootV;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)) {
                return edge;
            }
            union(u, v);
        }
        return new int[0];
    }
}
