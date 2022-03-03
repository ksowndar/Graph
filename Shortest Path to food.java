class Solution {
    int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int getFood(char[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        
        q.add(findStart(grid));
        
        boolean[][] visited=new boolean[m][n]; 
        int steps=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int x=q.peek()[0];
                int y=q.peek()[1];
                q.remove();
                
                if(grid[x][y]=='#')
                    return steps;
                
                for(int[] d:dir)
                {
                    int Xbox=x+d[0];
                    int Ybox=y+d[1];
                    
                    if(isValid(Xbox,Ybox,grid) && !visited[Xbox][Ybox])
                    {
                        visited[Xbox][Ybox]=true;
                        q.offer(new int[]{Xbox,Ybox});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private int[] findStart(char[][] grid)
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='*')
                    return new int[]{i,j};
            }
        }
        throw new RuntimeException();
    }
    boolean isValid(int i,int j,char[][] grid)
    {
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]!='X';
    }
}
