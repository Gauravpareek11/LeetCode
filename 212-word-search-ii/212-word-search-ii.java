class Trie{
    Trie[] Node=new Trie[26];
    boolean isWord=false;
    String name="";
    
    Trie get(char c){
        return Node[c-'a'];
    }
    boolean contains(char c){
        return Node[c-'a']!=null;
    }
}
class Solution {
    Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        List<String>ans=new ArrayList<>();
        root=new Trie();
        for(String s:words){
            insert(s);
        }
        boolean[][] vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                Trie p=root;
                find(i,j,board,p,vis,ans);
            }
        }
        
        return ans;
    }
//     boolean solve(char[][] board,String s){
//         boolean[][] visited=new boolean[board.length][board[0].length];
//         for(int i=0;i<board.length;i++){
//             for(int j=0;j<board[0].length;j++){
//                 if(s.charAt(0)==board[i][j]){
//                     if(find(i,j,board,s,visited)==1) return true;
//                 }
//             }
//         }
//         return false;
//     }
     void find(int i,int j,char[][] board,Trie p,boolean[][] vis,List<String>ans){
         if(i>=board.length || j>=board[0].length || i<0 || j<0 || !p.contains(board[i][j])
           || vis[i][j]){
             return;
         }
         p=p.get(board[i][j]);
         if(p.isWord){
             ans.add(p.name);
             p.isWord=false;
         }
         vis[i][j]=true;
         find(i-1,j,board,p,vis,ans);
         find(i,j-1,board,p,vis,ans);
         find(i+1,j,board,p,vis,ans);
         find(i,j+1,board,p,vis,ans);
         vis[i][j]=false;
    }
    
    void insert(String s){
        Trie p=root;
        for(char c:s.toCharArray()){
            if(p.contains(c)){
                p=p.get(c);
            }
            else{
                p.Node[c-'a']=new Trie();
                p=p.get(c);
            }
        }
        p.isWord=true;
        p.name=s;
    }
    
}