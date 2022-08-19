// class Solution {
//     public boolean isPossible(int[] nums) {
//         HashSet<Integer>s1=new HashSet<>();
//         HashSet<Integer>s2=new HashSet<>();
//         s1.add(nums[0]);
//         int prev=nums[0];
//         int p=Integer.MAX_VALUE;
//         for(int i=1;i<nums.length;i++){
//             if(prev-nums[i]==-1){
//                 s1.add(nums[i]);
//                 prev=nums[i];
//             }
//             else{
//                 if(s2.contains(nums[i])) return false;
//                 if(p!=Integer.MAX_VALUE && p-nums[i]!=-1) return false;
//                 s2.add(nums[i]);
//                 p=nums[i];
//             }
//         }
//         int c=0;
//         Iterator<Integer>it1=s2.iterator();
//         int min=Integer.MAX_VALUE;
//         int m=0;
//         while(it1.hasNext()){
//             int x=it1.next();
//             if(s1.contains(x)){
//                 min=Math.min(x,min);
//                 s1.remove(x);
//                 it1.remove();
//                 m++;
//                 c++;
//                 if(s2.isEmpty()) break;
//             }
            
//         }
//         Iterator<Integer>it=s1.iterator();
//         while(it.hasNext()){
//             if(it.next()>min) {
//                 it.remove();
//                 c++;
//             }
//             if(s1.isEmpty()) break;
//         }
//         if(c==0 && s1.size()>=3) return true;
//         if(m+s1.size()>=3 && c>=3) return true;
//         return false;
//     }
// }

class Solution {
    public boolean isPossible(int[] nums) {
        // greedy algorithm
        if (nums == null || nums.length < 3)
            return false;
        
        // map to save the frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        
        // map to save that the number of subsequences that are
        // ended with number i
        Map<Integer, Integer> tail = new HashMap<>();
        
        // first pass, fill teh freq map
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        // second pass:
        for (int i : nums) {
            // there is no such number available
            if (freq.get(i) == 0) {
                continue;
            }
            // if there is some subsequence that is ended with i - 1:
            // then we can put the number i in the subsequence
            if (tail.get(i-1) != null && tail.get(i-1) > 0) {
                // the number of sequence ended with i-1 decreases
                tail.put(i-1, tail.get(i-1) - 1);
                // the number of sequences ended with i increases
                tail.put(i, tail.getOrDefault(i, 0) + 1);
                // we used one number i, decrease the freq
                freq.put(i, freq.get(i) - 1);
            } else {
                // there is no such subsequence that is ended with i-1
                // we build a new subsequence start with i,
                // we then need i + 1 and i + 2 to make a valid subsequence
                if (freq.get(i+1) != null && freq.get(i+1) > 0 && 
                    freq.get(i+2) != null && freq.get(i+2) > 0) {
                    // if we have available i + 1 and i + 2
                    // we now have one more subsequence ended with i+2
                    tail.put(i+2, tail.getOrDefault(i+2, 0) + 1);
                    // decrease the frequency
                    freq.put(i, freq.get(i) - 1);
                    freq.put(i + 1, freq.get(i + 1) - 1);
                    freq.put(i + 2, freq.get(i + 2) - 1);
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}