// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class pair{
    int wt;
    int value;
    double ratio;
    pair(int a,int b,double c){
        this.wt=a;
        this.value=b;
        this.ratio=c;
    }
}
class Solution
{
    
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        pair[] k=new pair[n];
        for(int i=0;i<n;i++){
            k[i]=new pair(arr[i].weight,arr[i].value,(double)arr[i].value/arr[i].weight);
        }
        Arrays.sort(k,(x,y)->Double.compare(y.ratio,x.ratio));
        double ans=0;
        for(int i=0;i<n;i++){
            if(k[i].wt<=W){
                ans+=k[i].value;
                W-=k[i].wt;
            }
            else{
                ans+=(W*k[i].ratio);
                W=0;
            }
        }
        return ans;
    }
}