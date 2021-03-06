class Solution {
    public int threeSumMulti(int[] A, int target) {
        int MOD =(int)1e9+7;
        long[] count = new long[101];
        for (int x: A)
            count[x]++;

        long ans = 0;

//         for (int x = 0; x <= 100; ++x)
//             for (int y = x+1; y <= 100; ++y) {
//                 int z = target - x - y;
//                 if (y < z && z <= 100) {
//                     ans += count[x] * count[y] * count[z];
//                     ans %= MOD;
//                 }
//             }

//         for (int x = 0; x <= 100; ++x) {
//             int z = target - 2*x;
//             if (x < z && z <= 100) {
//                 ans += count[x] * (count[x] - 1) / 2 * count[z];
//                 ans %= MOD;
//             }
//         }

//         for (int x = 0; x <= 100; ++x) {
//             if (target % 2 == x % 2) {
//                 int y = (target - x) / 2;
//                 if (x < y && y <= 100) {
//                     ans += count[x] * count[y] * (count[y] - 1) / 2;
//                     ans %= MOD;
//                 }
//             }
//         }

//         if (target % 3 == 0) {
//             int x = target / 3;
//             if (0 <= x && x <= 100) {
//                 ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
//                 ans %= MOD;
//             }
//         }
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                int k=target-j-i;
                if(k<0 || k>100) continue;
                else if(i==j && j==k){
                    ans+=(count[i]*(count[i]-1)*(count[i]-2))/6;
                    ans=ans%MOD;
                }
                else if(i== j && j!=k){
                    ans+=(count[i]*(count[i]-1)/2)*count[k];
                    ans=ans%MOD;
                }
                else if(i<j && j<k){
                    ans+=count[i]*count[j]*count[k];
                    ans=ans%MOD;
                }
            }
        }

        return (int) ans;
    }
}