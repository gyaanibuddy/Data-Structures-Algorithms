// Problem :- To find the longest path in the directed unweighted (acyclic) graph 

 
// Steps:- 
// 1) it is given that graph is acyclic and unweighted directed.
// 2) We only need to find maximum depth a recursion (dfs) can go, that will give us max length.
// 3) Add memoization to avoid recomputing.

int dfs(vector<vector<int>>& graph, int s, vector<int>& dis) {
    if (dis[s] != -1) return dis[s];

    if (graph[s].size() == 0) return dis[s] = 0;

    int ans = 0;
    for (auto v : graph[s]) {
        ans = max(ans, dfs(graph, v, dis));
    }

    return dis[s] = ans + 1;
}
int solve(vector<vector<int>>& graph) {
    int n = graph.size();

    int len = 0;
    vector<int> dis(n, -1);
    for (int i = 0; i < n; i++) {
        dis[i] = dfs(graph, i, dis), len = max(len, dis[i]);
    }
    // for(int i=0;i<n;i++)cout<<dis[i]<<" ";
    return len;
}
