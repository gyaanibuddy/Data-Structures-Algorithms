
// Steps:-
//1) Perform a dFS run from each vertex and also keep storing the maximum recorded path from a vertex in a 
//   memo/cache table so that it can be used in subsequent DFS runs
//2) so dfs(i) would be -> return (memo[i] = 1+ Max (dfs (i1), dfs(i2), dfs(i3).....)
//3) for all directed edges from i to i1 , i2,..i3...and storing the max recorded path into the memo table

import java.util.*;

class Solution {
    private int maxLen = 0;
    private int[] memo;
    public int solve(int[][] graph) {
        if (graph == null || graph.length == 0)
            return 0;
        memo = new int[graph.length + 1];
        Arrays.fill(memo, -1);

        for (int i = 0; i < graph.length; i++) maxLen = Math.max(maxLen, dfs(graph, i));
        return maxLen - 1;
    }

    private int dfs(int[][] graph, int vertex) {
        if (memo[vertex] != -1)
            return memo[vertex];
        int maxPath = 0;
        for (int adjacentVertex : graph[vertex]) {
            maxPath = Math.max(maxPath, dfs(graph, adjacentVertex));
        }
        return memo[vertex] = 1 + maxPath;
    }
}
