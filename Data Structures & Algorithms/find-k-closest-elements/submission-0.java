class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length - 1;

        while(j - i >= k) {
            if(Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) {
                i++;
            } else {
                j--;
            }
        }

        List<Integer> al = new ArrayList<>();
        for(int ele = i; ele <= j; ele++) {
            al.add(arr[ele]);
        }
        return al;
    }
}