There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.

Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,

The cost is the sum of the connections' costs used.

 

Example 1:


Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.
Example 2:


Input: n = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: There is no way to connect all cities even if all edges are used.

class Solution {
    
    int[] parent;
    int N;
    
    private int find(int x)
    {
        if(parent[x]==x)
            return parent[x];
        parent[x]=find(parent[x]);
        return parent[x];
    }
    
    private void union(int x,int y)
    {
        int px=find(x);
        int py=find(y);
        if(px!=py)
        {
            parent[px]=py;
            N--;
        }
    }
    
    public int minimumCost(int n, int[][] connections) {
        N=n;
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
        }
        
        Arrays.sort(connections,(a,b) -> (a[2]-b[2]));
        
        int res=0;
        
        for(int[] c:connections)
        {
            int x=c[0];
            int y=c[1];
            if(find(x)!=find(y))
            {
                res+=c[2];
                union(x,y);
            }
        }
        return N==1?res:-1;
    }
}
