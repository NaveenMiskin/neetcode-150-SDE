class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int curTank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];

            totalGas += gain;
            curTank += gain;

            if(curTank < 0) {
                start = i + 1;
                curTank = 0;
            }
        }
        if(totalGas < 0) {
            return -1;
        }
        return start;
    }
}
