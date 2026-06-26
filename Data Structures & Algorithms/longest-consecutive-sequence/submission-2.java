class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        int cnt = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);

        for(int ele : hs) {
            if(!hs.contains(ele-1)) {
                cnt = 1;
                int x = ele;
                while(hs.contains(x+1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
