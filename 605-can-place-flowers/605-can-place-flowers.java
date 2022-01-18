class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        if(n==0) return true;
        if(flowerbed.length==1){
            if((flowerbed[0]==0 && n==1) || (flowerbed[0]==1 && n==0)) return true;
            else return false;
        }
        
        for(int i=0;i<flowerbed.length;i++){
            if(i==0 && i+1<flowerbed.length && flowerbed[i]!=1 && flowerbed[i+1]!=1){
                flowerbed[i]=1;
                count++;
            }
            else if(i==flowerbed.length-1 && i-1>=0 && flowerbed[i]!=1 && flowerbed[i-1]!=1){
                flowerbed[i]=1;
                count++;
            }
            else{
                if(flowerbed[i]!=1 && i-1>=0 && i+1<flowerbed.length && flowerbed[i-1]!=1 && flowerbed[i+1]!=1){
                    count++;
                    flowerbed[i]=1;
                }
            }
        }
        // System.out.println(count);
        return count>=n;
    }
}