class Solution {
    public List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        if(topo.size() == n) return topo;
        return new ArrayList<>();
    }
    public String foreignDictionary(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] present = new boolean[26];
        for(String word : words) {
            for(char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if(s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j < len; j++) {
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';
                if(u != v) {
                    adj.get(u).add(v);
                    break;
                }
            }  
        }

        List<Integer> topo = topoSort(26, adj);
        if(topo.isEmpty()) return "";

        String res = "";
        for(Integer it : topo) {
            if(present[it]) {
                res = res + (char)(it + (int)'a');
            }
        }
        return res;
    }
}
