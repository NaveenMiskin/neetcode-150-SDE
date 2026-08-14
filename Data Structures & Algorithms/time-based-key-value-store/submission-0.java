class TimeMap {

    class TimeValue {
        String value;
        int timeStamp;
        public TimeValue(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<TimeValue> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;
        String result = "";

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(list.get(mid).timeStamp <= timestamp) {
                result = list.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
