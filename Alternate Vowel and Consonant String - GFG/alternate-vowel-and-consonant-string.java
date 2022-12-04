//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        int[] vowel=new int[26];
        int[] cons=new int[26];
        HashSet<Character>s1=new HashSet<>();
        s1.add('a');
        s1.add('e');
        s1.add('i');
        s1.add('o');
        s1.add('u');
        int v_count=0;
        int c_count=0;
        for(int i=0;i<N;i++){
            if(s1.contains(S.charAt(i))){
                vowel[S.charAt(i)-'a']++;
                v_count++;
            }
            else{
                cons[S.charAt(i)-'a']++;
                c_count++;
            }
        }
        // System.out.println(v_count+" "+c_count);
        StringBuilder sb=new StringBuilder("");
        if(v_count>c_count){
            boolean f=true;
            int i=0;
            int v=0;
            int c=0;
            boolean x=false;
            while(i<N){
                if(f){
                    for(int j=v;j<26;j++){
                        if(vowel[j]>0){
                            sb.append((char)(97+j));
                            vowel[j]--;
                            v=j;
                            f=false;
                            break;
                        }
                        // System.out.println(f);
                    }
                    if(f) x=true;
                    if(x) break;
                }
                else{
                    for(int j=c;j<26;j++){
                        if(cons[j]>0){
                            sb.append((char)(97+j));
                            cons[j]--;
                            c=j;
                            f=true;
                            break;
                        }
                        // System.out.println(f);
                    }
                    if(!f) x=true;
                    if(x) break;
                }
                i++;
            }
        }
        else if(c_count>v_count){
            boolean f=false;
            int i=0;
            int v=0;
            int c=0;
            boolean x=false;
            while(i<N){
                if(f){
                    for(int j=v;j<26;j++){
                        if(vowel[j]>0){
                            sb.append((char)(97+j));
                            vowel[j]--;
                            v=j;
                            f=false;
                            break;
                        }
                    }
                    if(f) x=true;
                    if(x) break;
                }
                else{
                    for(int j=c;j<26;j++){
                        if(cons[j]>0){
                            sb.append((char)(97+j));
                            cons[j]--;
                            c=j;
                            f=true;
                            break;
                        }
                    }
                    if(!f) x=true;
                    if(x) break;
                }
                i++;
            }
        }
        else{
            boolean f=true;
            int v=0;
            int c=0;
            for(int i=0;i<26;i++){
                if(vowel[i]>0){
                    v=i;
                    break;
                }
            }
            for(int i=0;i<26;i++){
                if(cons[i]>0){
                    c=i;
                    break;
                }
            }
            if(c<v) f=false;
            int i=0;
            boolean x=false;
            while(i<N){
                if(f){
                    for(int j=v;j<26;j++){
                        if(vowel[j]>0){
                            sb.append((char)(97+j));
                            vowel[j]--;
                            v=j;
                            f=false;
                            break;
                        }
                        
                    }
                    if(f) x=true;
                    if(x) break;
                }
                else{
                    for(int j=c;j<26;j++){
                        if(cons[j]>0){
                            sb.append((char)(97+j));
                            cons[j]--;
                            c=j;
                            f=true;
                            break;
                        }
                        
                    }
                    if(!f) x=true;
                    if(x) break;
                }
                i++;
            }
        }
        if(sb.toString().length()<N) return "-1";
        return sb.toString();
    }
}