class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int card : hand) {
            tm.put(card, tm.getOrDefault(card, 0) + 1);
        }

        while(!tm.isEmpty()) {
            int firstCard = tm.firstKey();

            for(int i = 0; i < groupSize; i++) {
                int curCard = firstCard + i;

                if(!tm.containsKey(curCard)) return false;

                int count = tm.get(curCard);
                if(count == 1) {
                    tm.remove(curCard);
                } else {
                    tm.put(curCard, count - 1);
                }
            }
        }
        return true;
    }
}
