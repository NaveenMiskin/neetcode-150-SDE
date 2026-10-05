class LRUCache {
    class Pair {
        int key, value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<Pair> lru = new ArrayList<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for(int i = 0; i < lru.size(); i++) {
            if(lru.get(i).key == key) {
                Pair pair = lru.get(i);

                lru.remove(i);

                lru.add(pair);
                
                return pair.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < lru.size(); i++) {
            if(lru.get(i).key == key) {

                lru.remove(i);

                lru.add(new Pair(key, value));
                return;
            }
        }
        if(lru.size() == capacity) {
            lru.remove(0);
        }
        
        lru.add(new Pair(key, value));
    }
}
