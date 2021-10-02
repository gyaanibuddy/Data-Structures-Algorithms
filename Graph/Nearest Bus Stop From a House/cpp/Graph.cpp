// Problem :- 

/*

    You are given a two-dimensional integer matrix containing 0s, 1s, 2s, and 3s where

    0 represents an empty cell
    1 represents a wall
    2 represents a house
    3 represents a bus stop
    Return the shortest distance from any house to any bus stop. 
    You can move up, down, left, and right but you can't move through a house or a wall cell.

*/

// Intuition :- 
/*
The intiution is same as the other editorials present here just differs in the implementation.

When we do bfs we always reach a destination in least distance (paths).
Just push all the sources in the queue and do the bfs
*/

vector<pair<int, int>> paths = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

inline bool valid(int i, int j, int r, int c) {
    if (i < 0 || j < 0 || i >= r || j >= c) return false;
    return true;
}

int solve(vector<vector<int>>& matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    queue<array<int, 3>> Q;
    vector<vector<bool>> visited(n, vector<bool>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] == 2) {
                Q.push({i, j, 0});
                visited[i][j] = true;
            } else if (matrix[i][j] == 1) {
                visited[i][j] = true;
            }
        }
    }

    while (Q.size()) {
        auto f = Q.front();
        Q.pop();
        for (auto& p : paths) {
            int i = p.first + f[0];
            int j = p.second + f[1];
            if (i >= 0 && j >= 0 && i < n && j < m && !visited[i][j]) {
                if (matrix[i][j] == 3) {
                    return f[2] + 1;
                }
                visited[i][j] = true;
                Q.push({i, j, f[2] + 1});
            }
        }
    }

    return -1;
}