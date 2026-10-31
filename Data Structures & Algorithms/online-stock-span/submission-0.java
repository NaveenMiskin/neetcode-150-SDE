class StockSpanner {
    class Pair {
        int price, ind;
        public Pair(int price, int ind) {
            this.price = price;
            this.ind = ind;
        }
    }

    Stack<Pair> st;
    int ind;
    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    public int next(int price) {
        int ans = 0;
        ind += 1;
        
        while(!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }
        ans = ind - (st.isEmpty() ? -1 : st.peek().ind);
        st.push(new Pair(price, ind));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */