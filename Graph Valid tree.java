class Solution {
    boolean[] visited;
    List<Integer>[] adj;
    public boolean validTree(int n, int[][] edges) {
        adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<Integer>();
        }
        for(int[] edge:edges)
        {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        visited=new boolean[n];
        if(!dfs(visited,0,-1,adj))
            return false;
        for(boolean b:visited)
        {
            if(!b)
                return false;
        }
        return true;
    }
    boolean dfs(boolean[] visited,int v,int p,List<Integer>[] adj)
    {
        visited[v]=true;
        for(Integer i:adj[v])
        {
            if(i==p)
                continue;
            if(visited[i]||!dfs(visited,i,v,adj))
                return false;
        }
        return true;
    }
}
