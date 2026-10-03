class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks) {
            map[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int it : map) {
            if(it > 0) {
                pq.offer(it);
            }
        }

        int time = 0;

        while(!pq.isEmpty()) {
            int idx = 0;
            int[] temp = new int[26];

            for(int i = 1; i <= n + 1; i++) {
                if(!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    temp[idx++] = freq;
                } else {}
            }

            for(int f : temp) {
                if(f > 0) {
                    pq.offer(f);
                }
            }

            if(!pq.isEmpty()) {
                time += n + 1;
            } else {
                time += idx;
            }
        }
        return time;
    }
}