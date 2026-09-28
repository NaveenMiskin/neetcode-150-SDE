class CountSquares {

    private int[][] pointCounts;

    private List<int[]> points;

    public CountSquares() {
        pointCounts = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        pointCounts[x][y]++;
        points.add(point);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];
        int totalSquares = 0;

        for(int[] p : points) {
            int x = p[0];
            int y = p[1];

            if(Math.abs(qx - x) == Math.abs(qy - y) && x != qx) {
                totalSquares += pointCounts[x][qy] * pointCounts[qx][y];
            }
        }
        return totalSquares;
    }
}
