class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            int cursum = numbers[i] + numbers[j];
            if(cursum == target) return new int[]{i + 1, j + 1};
            if(cursum < target) i++;
            else j--;
        }
        return new int[0];
    }
}
