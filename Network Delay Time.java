You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            int src=time[0],tar=time[1],wt=time[2];
            if(!graph.containsKey(src))
                graph.put(src,new LinkedList<int[]>());
            graph.get(src).add(new int[]{tar,wt});
        }
        
        Queue<int[]> minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Set<Integer> visited=new HashSet<>();
        minHeap.add(new int[]{k,0});
        int result=0;
        
        while(!minHeap.isEmpty())
        {
            int[] top=minHeap.poll();
            int src=top[0],srcWeight=top[1];
            if(visited.contains(src))
                continue;
            result=srcWeight;
            visited.add(src);
            if(!graph.containsKey(src))
                continue;
            for(int[] edge:graph.get(src))
            {
                int tar=edge[0],tarWeight=edge[1];
                minHeap.add(new int[]{tar,srcWeight+tarWeight});
            }
        }
        return visited.size()!=n?-1:result;
    }
}
