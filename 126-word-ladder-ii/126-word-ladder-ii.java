class Solution {
	List<List<String>> results;
	List<String> list;
	Map<String,List<String>> map;
	    public List<List<String>> findLadders(String start, String end,List<String>words) {
            Set<String>dict=new HashSet<>();
            for(String x:words){
                dict.add(x);
            }
	        results= new ArrayList<List<String>>();
	        if (dict.size() == 0)
				return results;
	        if(!dict.contains(end)) return results;
	        int curr=1,next=0;	        
	        boolean found=false;	        
	        list = new LinkedList<String>();	       
			map = new HashMap<String,List<String>>();
			
			Queue<String> queue= new ArrayDeque<String>();
			Set<String> unvisited = new HashSet<String>(dict);
			Set<String> visited = new HashSet<String>();
			
			queue.add(start);			
			unvisited.add(end);
			unvisited.remove(start);
			//BFS
			while (!queue.isEmpty()) {
			   
				String word = queue.poll();
				curr--;				
				for (int i = 0; i < word.length(); i++){
				   StringBuilder builder = new StringBuilder(word); 
					for (char ch='a';  ch <= 'z'; ch++){
						builder.setCharAt(i,ch);
						String new_word=builder.toString();	
						if (unvisited.contains(new_word)){
							//Handle queue
							if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
								next++;
								queue.add(new_word);
							}
							
							if (map.containsKey(new_word))//Build Adjacent Graph
								map.get(new_word).add(word);
							else{
								List<String> l= new LinkedList<String>();
								l.add(word);
								map.put(new_word, l);
							}
							
							if (new_word.equals(end)&&!found) found=true;		
														
						}

					}//End:Iteration from 'a' to 'z'
				}//End:Iteration from the first to the last
				if (curr==0){
					if (found) break;
					curr=next;
					next=0;
					unvisited.removeAll(visited);
					visited.clear();
				}
			}//End While

			backTrace(end,start);
			
			return results;        
	    }
	    private void backTrace(String word,String start){
	    	if (word.equals(start)){
	    		list.add(0,start);
	    		results.add(new ArrayList<String>(list));
	    		list.remove(0);
	    		return;
	    	}
	    	list.add(0,word);
	    	if (map.get(word)!=null)
	    		for (String s:map.get(word))
	    			backTrace(s,start);
	    	list.remove(0);
	    }
	}







// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         List<List<String>>ans=new ArrayList<>();
//         if(!wordList.contains(endWord)) return ans;
//         HashSet<String>s1=new HashSet<>();
//         HashMap<String,List<String>>m1=new HashMap<>();
//         for(String s:wordList){
//             s1.add(s);
//             if(s.equals(beginWord)) continue;
//             if(isAdj(beginWord,s)){
//                 if(m1.containsKey(beginWord)){
//                     m1.get(beginWord).add(s);
//                 }
//                 else{
//                     List<String> t=new ArrayList<String>();
//                     t.add(s);
//                     m1.put(beginWord,t);
//                 }
//             }
//         }
//         for(String s:s1){
//             if(s.equals(endWord) || s.equals(beginWord)) continue;
//             for(String x:s1){
//                 if(isAdj(s,x)){
//                     if(m1.containsKey(s)){
//                         m1.get(s).add(x);
//                     }
//                     else{
//                         List<String> t=new ArrayList<String>();
//                         t.add(x);
//                         m1.put(s,t);
//                     }
//                 }
//             }
//         }
//         // System.out.println(m1);
//         if(m1.size()==0) return ans;
//         List<String>l1=new ArrayList<>();
//         HashSet<String>temp=new HashSet<>();
//         temp.add(beginWord);
//         l1.add(beginWord);
//         solve(beginWord,endWord,m1,l1,ans,temp);
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<ans.size();i++){
//             min=Math.min(min,ans.get(i).size());
//         }
//         List<List<String>>fs=new ArrayList<>();
//         for(int i=0;i<ans.size();i++){
//             if(ans.get(i).size()==min){
//                 fs.add(ans.get(i));
//             }
//         }
//         return fs;
//     }
//     void solve(String s,String endWord,HashMap<String,List<String>>m1,List<String>l1,List<List<String>>ans,HashSet<String>temp){
//         if(s.equals(endWord)){
//             // System.out.println(l1);
//             ans.add(new ArrayList<>(l1));
//             return;
//         }
//         if(!m1.containsKey(s)) return;
//         for(String x:m1.get(s)){
//             if(temp.contains(x)) continue;
//             l1.add(x);
//             temp.add(x);
//             solve(x,endWord,m1,l1,ans,temp);
//             temp.remove(x);
//             l1.remove(x);
//         }
//     }
//     boolean isAdj(String s,String x){
//         if(s.length()!=x.length()) return false;
//         int c=0;
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)!=x.charAt(i)) c++;
//         }
//         return c==1;
//     }
// }