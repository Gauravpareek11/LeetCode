class Solution {
    long mod=(long)1e9+7;
    public int numFactoredBinaryTrees(int[] A) {
//         HashSet<Integer>s1=new HashSet<Integer>();
//         for(int i:arr){
//             s1.add(i);
//         }
//         Hashmap<Integer,HashSet<Integer>>m1=new HashMap<>();
//         for(int i:arr){
//             HashSet<Integer>s2=new HashSet<>();
//             for(int x=2;x*x<=i;x++){
//                 if(i%x==0){
//                     if(x==i/x){
//                        if(s1.contains(i)) s2.add(i); 
//                     } 
//                     else{
//                         if(s1.contains(i)) s2.add(i);
//                         if(s1.contains(x/i)) s2.add(x/i);
//                     }
//                 }
//             }
//            if(s2.size()>1) m1.put(i,s2);
//         }
//         int ans=0;
//         for(int i:m1.keySet()){
            
//         }
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % MOD);
    }
}