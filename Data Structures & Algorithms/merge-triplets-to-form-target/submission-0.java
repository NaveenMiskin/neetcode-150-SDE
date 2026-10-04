class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean foundx = false;
        boolean foundy = false;
        boolean foundz = false;

        for(int[] t : triplets) {

            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            if(t[0] == target[0]) foundx = true;
            if(t[1] == target[1]) foundy = true;
            if(t[2] == target[2]) foundz = true;

            if(foundx && foundy && foundz) {
                return true;
            }
        }

        return foundx && foundy && foundz;
    }
}
