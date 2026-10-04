class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();

    private void DFS(String airport) {
        PriorityQueue<String> pq = graph.get(airport);
        while(pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            DFS(next);
        }
        result.add(airport);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        DFS("JFK");

        Collections.reverse(result);

        return result;
    }
}
