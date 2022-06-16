// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends



//User function Template for Java

class Solution{
    
    static int no_of_chars = 256;
    public int findSubString(String str) {
        int len1 = str.length();
        String pat = "";
        HashSet<Character> s = new HashSet<>();
        //set<char> s;
        for (int i = 0; i < len1; i++)
            s.add(str.charAt(i));
        
        for(char c: s)
            pat+=c;
                
        int len2 = pat.length();
    
        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (len1 < len2) {
            return 0;
        }
    
        int [] hash_pat = new int[no_of_chars];
        int [] hash_str = new int[no_of_chars];
    
        // store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++) hash_pat[pat.charAt(i)]++;
    
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
    
        // start traversing the string
        int count = 0; // count of characters
        for (int j = 0; j < len1; j++) {
            // count occurrence of characters of string
            hash_str[str.charAt(j)]++;
    
            // If string's char matches with pattern's char
            // then increment count
            if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
                count++;
    
            // if all the characters are matched
            if (count == len2) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] ||
                       hash_pat[str.charAt(start)] == 0) {
    
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }
    
                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
    
        // If no window found
        if (start_index == -1) {
            return 0;
        }
    
        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index+min_len).length();
    }
}