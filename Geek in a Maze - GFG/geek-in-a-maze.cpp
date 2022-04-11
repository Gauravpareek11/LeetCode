// { Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{

	private:
	bool isValid(int row,int col,int n, int m)
    {
    	if(row>=0 && row<n && col>=0 && col<m)
    		return true;
 
    	return false;
    }
 

	public:
	int numberOfCells(int n, int m, int r, int c, int u, int d, vector<vector<char>> &mat)
	{
	    if(mat[r][c] == '#')
            return 0;
		priority_queue <pair<pair <int, int>, pair <int, int>>, vector <pair <pair <int, int>, pair <int, int> >>, greater <pair <pair <int, int>, pair <int, int> >>> q;

		vector<vector<int>> vis(n, vector<int>(m, 0));
		
		q.push({{0,0},{r,c}});
    	vis[r][c] = 1;	
 
    	while(!q.empty())
    	{
    		int x, y, up, down; 
    		up = q.top().first.first;
    		down = q.top().first.second; 
 
    		x = q.top().second.first; 
    		y = q.top().second.second; 
 
    		q.pop();
 
    		if(isValid(x - 1, y, n, m))
    		{
    			if(up + 1 <= u && !vis[x - 1][y] && down <= d && mat[x - 1][y]=='.')
    			{
    			   q.push({{up + 1, down},{x - 1, y}});	
    			   vis[x - 1][y] = 1;	
    			}
    		}
 
    		if(isValid(x + 1, y, n, m))
    		{
    			if(down + 1 <= d && !vis[x + 1][y] && up <= u && mat[x + 1][y]=='.')
    			{
    			   q.push({{up, down + 1},{x + 1, y}});	
    			   vis[x + 1][y] = 1;	
    			}
    		}
 
    		if(isValid(x, y - 1, n, m))
    		{
    			if(down <= d && !vis[x][y - 1] && up <= u && mat[x][y - 1]=='.')
    			{
    			   q.push({{up, down},{x, y - 1}});	
    			   vis[x][y - 1] = 1;	
    			}
    		}
 
    		if(isValid(x, y + 1, n, m))
    		{
    			if(down <= d && !vis[x][y + 1] && up <= u && mat[x][y + 1]=='.')
    			{
    			   q.push({{up, down},{x,y + 1}});
    			   vis[x][y + 1] = 1;	
    			}
    		}
 
    	}


    	int ans = 0;
 
    	for(int i = 0; i < n; i++)
    	{
    		for(int j = 0; j < m; j++)
    		{
    			if(vis[i][j] == 1)
    			{
    				ans++;
    			}
    		}
    		
    	}
 
    	return ans;
	}

};



// { Driver Code Starts.

int main() 
{
   	
   	int t;
    cin >> t;

    while (t--)
    {
    	int n, m, r, c, u, d;
        cin >> n >> m >> r >> c >> u >> d;
        
        vector<vector<char>> mat(n, vector<char>(m, '.'));

        for(int i = 0; i < n; i++)
        {
        	for(int j = 0; j < m; j++)
        	{
        		cin >> mat[i][j];
        	}
        }

      

        Solution obj;
        cout << obj.numberOfCells(n, m, r, c, u, d, mat) << "\n";
    
    }

    return 0;
}


  // } Driver Code Ends