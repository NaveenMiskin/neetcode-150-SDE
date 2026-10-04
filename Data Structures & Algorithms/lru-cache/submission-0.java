class LRUCache {
    class Pair {
        int key, value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    ArrayList<Pair> LRU = new ArrayList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for(int i = 0; i < LRU.size(); i++) {
            if(LRU.get(i).key == key) {
                Pair pair = LRU.get(i);

                LRU.remove(i);

                LRU.add(pair);

                return pair.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < LRU.size(); i++) {
            if(LRU.get(i).key == key) {

                LRU.remove(i);

                LRU.add(new Pair(key, value));

                return;
            }
        }

        if(LRU.size() == capacity) {
            LRU.remove(0);
        }

        LRU.add(new Pair(key, value));
    }
}
