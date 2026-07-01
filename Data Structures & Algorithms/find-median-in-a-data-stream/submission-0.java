class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a , b) -> b - a);
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(min.size() > max.size()) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() > min.size()) return max.peek();
        return (min.peek() + max.peek()) / 2.0;
    }
}
