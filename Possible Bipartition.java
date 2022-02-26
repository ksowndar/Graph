We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
  
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();
        for (int[] d : dislikes)
        {
            int a = d[0] - 1, b = d[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] colours=new int[n];
        for(int i=0;i<n;i++)
        {
            if(colours[i]==0 && !validColour(graph,colours,1,i))
            {
                return false;
            }
        }
        return true;
    }
    boolean validColour(List<Integer>[] graph,int[] colours,int color,int i)
    {
        if(colours[i]!=0)
            return colours[i]==color;
        colours[i]=color;
        for(int j:graph[i])
        {
            if(!validColour(graph,colours,-color,j))
            {
                return false;
            }
        }
        return true;
    }
}  
