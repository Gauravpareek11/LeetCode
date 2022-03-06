class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int x=image[sr][sc];
        if(x!=newColor){
         Fill(image,sr,sc,newColor,x);   
        }
        return image;
    }
    void Fill(int[][] image,int sr,int sc,int newColor,int x){
        if(sr<0 && sr>=image.length){
            return;
        }
        if(sc<0 && sc>=image[0].length){
            return;
        }
        if(image[sr][sc]==x){
            image[sr][sc]=newColor;
        if(sr+1<image.length){
            Fill(image,sr+1,sc,newColor,x);
        }
        if(sr-1>=0){
          Fill(image,sr-1,sc,newColor,x);  
        }
        if(sc+1<image[0].length){
            Fill(image,sr,sc+1,newColor,x);
        }
        if(sc-1>=0){
            Fill(image,sr,sc-1,newColor,x);
        }
      }
    }
}