class Solution {
    public int calcTotalHours(int[] arr, int hourly) {
        double totalHrs = 0;
        for(int i = 0; i < arr.length; i++) {
            totalHrs += Math.ceil((double)arr[i] / (double)hourly);
        }
        return (int)totalHrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int num : piles) {
            max = Math.max(max, num);
        }

        int l = 0; 
        int r = max;
        while(l <= r) {
            int mid = l + (r - l) / 2;

            int totalHours = calcTotalHours(piles, mid);
            if(totalHours <= h) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
