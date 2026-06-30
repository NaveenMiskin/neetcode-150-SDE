class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num : stones) {
            pq.add(num);
        }

        while(pq.size() > 1){
            int top = pq.poll();
            int ans = top - pq.poll();
            pq.add(ans);
        }
        return pq.peek();
    }
}
