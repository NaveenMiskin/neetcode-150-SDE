class LRUCache {
    class Pair {
        int key, value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    List<Pair> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i = 0; i < cache.size(); i++) {
            Pair cur = cache.get(i);
            if(cur.key == key) {
                cache.remove(i);
                cache.add(cur);
                return cur.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < cache.size(); i++) {
            Pair cur = cache.get(i);
            if(cur.key == key) {
                cur.value = value;
                cache.remove(i);
                cache.add(cur);
                return;
            }
        }
        if(cache.size() == capacity) {
            cache.remove(0);
        }

        cache.add(new Pair(key, value));
    }
}
