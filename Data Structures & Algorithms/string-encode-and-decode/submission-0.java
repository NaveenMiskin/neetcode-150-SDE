class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);

            encoded += str.length() + "#";
            encoded += str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> st = new ArrayList<>();

        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(
                str.substring(i, j)
            );

            j++;

            String s = str.substring(j, j + len);

            st.add(s);
            i = j + len;
        }
        return st;
    }
}
