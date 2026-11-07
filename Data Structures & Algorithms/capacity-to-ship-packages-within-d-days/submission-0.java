class Solution {
    int canShip(int[] arr, int cap) {
        int day = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum + arr[i] > cap) {
                day++;
                sum = 0;
            }
            sum += arr[i];
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int h = 0;

        for(int num : weights) {
            l = Math.max(l, num);
            h += num;
        }

        while(l <= h) {
            int mid = l + (h - l) / 2;

            if(canShip(weights, mid) > days) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}