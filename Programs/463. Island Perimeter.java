class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int red = 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    if(i+1 < r && grid[i+1][j]==1) red += 2;
                    if(j+1 < c && grid[i][j+1]==1) red += 2;
                }
            }
        }

        return perimeter-red;
    }
}