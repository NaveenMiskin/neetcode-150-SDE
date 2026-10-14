class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        for(int num : hm.keySet()) {
            if(hm.get(num) > n / 3) {
                ans.add(num);
            }
        }
        return ans;
    }
}