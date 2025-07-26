class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // fill(image,sr,sc,color,image[sr][sc]);
        if (image[sr][sc] != color) {
        fill(image, sr, sc, color, image[sr][sc]);
    }
        return image;
    }


    public void fill(int[][] image, int i, int j, int color, int prev){
        // Base case for checking i & j are within the matrix Bounds
        if(i<0 ||j<0 || i>image.length-1 || j>image[0].length-1){
            return;
        }
        // Skiping if the pixels val is diff from intial val or original val
        if(image[i][j]!=prev)return;
         // Changing if the pixels val is same to inital one
        image[i][j] = color;
        // Treversing the whole matrix (Image[][])
        fill(image,i-1,j,color,prev); //Vertically Top pixel
        fill(image,i+1,j,color,prev); //Vertically Down pixel
        fill(image,i,j-1,color,prev); //Horizontally Left pixel
        fill(image,i,j+1,color,prev); //horizontally  Right pixel
    }
}