class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int i = 0; 
        int j = s.length() - 1;

        while(i <= j) {
            int left = s.charAt(i);
            int right = s.charAt(j);
            if(left != right) return false;
            i++;
            j--;
        }
        return true;
    }
}
