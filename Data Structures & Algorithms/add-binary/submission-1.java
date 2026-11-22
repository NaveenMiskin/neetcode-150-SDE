class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1; // CHANGED: single pointer for string a instead of nested loops
        int j = b.length() - 1; // CHANGED: single pointer for string b instead of nested loops

        while (i >= 0 || j >= 0 || carry > 0) { // CHANGED: loop while either string has bits or carry remains
            int sum = carry; // CHANGED: start current bit sum with existing carry

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // CHANGED: convert char '0'/'1' to int 0/1 using - '0'
                i--; // CHANGED: decrement pointer i
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0'; // CHANGED: convert char '0'/'1' to int 0/1 using - '0'
                j--; // CHANGED: decrement pointer j
            }

            sb.append(sum % 2); // CHANGED: append binary digit (0 or 1), not raw sum or ASCII codes
            carry = sum / 2; // CHANGED: update carry (0 or 1)
        }

        return sb.reverse().toString();
    }
}