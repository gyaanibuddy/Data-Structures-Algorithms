// Problem:- 
//Given a two-dimensional list of integers matrix containing 0s and 1s, 0 represents water and 1 represents land.
// Find the shortest bridge that connects two islands. (There will only be 2 islands given in the problem)



void dfs(vector<vector<int>> &matrix, int x, int y, queue<pair<int, int>> &q) {
    // Invalid position or cell-state
    if (x < 0 || y < 0 || x >= matrix.size() || y >= matrix[0].size() || matrix[x][y] == 2 ||
        matrix[x][y] < 0) {
        return;
    }

    // If the cell is a water cell adjacent to the island
    // mark it and place it into the bfs queue and return
    if (matrix[x][y] == 0) {
        matrix[x][y] = -1;
        q.emplace(make_pair(x, y));
        return;
    }

    // Mark island cell with different color
    if (matrix[x][y] == 1) {
        matrix[x][y] = 2;
    }

    // run dfs to mark neighbors
    vector<vector<int>> dirs{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    for (auto &dir : dirs) {
        int x1 = x + dir[0];
        int y1 = y + dir[1];

        dfs(matrix, x1, y1, q);
    }
}

int solve(vector<vector<int>> &matrix) {
    int m = matrix.size(), n = m == 0 ? 0 : matrix[0].size();

    // Find the first land cell (can be any of the two islands)
    // and run dfs to mark the island with a different color
    bool landFound = false;
    queue<pair<int, int>> q;
    for (int x = 0; x < m && !landFound; ++x) {
        for (int y = 0; y < n && !landFound; ++y) {
            if (matrix[x][y] == 1) {
                landFound = true;
                dfs(matrix, x, y, q);
            }
        }
    }

    // Means that there's no island at all
    // so return error
    if (q.empty()) {
        return -1;
    }

    // Run bfs from the edges of the marked island
    vector<vector<int>> dirs{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    while (!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();

        for (auto &dir : dirs) {
            int x = curr.first + dir[0];
            int y = curr.second + dir[1];

            if (x >= 0 && y >= 0 && x < m && y < n) {
                // If we have found the second island
                // return the distance
                // distance is -ve of the current cell
                // since we've marked water cells with
                // increasing negative values
                if (matrix[x][y] == 1) {
                    return 0 - matrix[curr.first][curr.second];
                }
                // If it is a water cell, update its distance
                // and then add it to the queue
                else if (matrix[x][y] == 0) {
                    matrix[x][y] = matrix[curr.first][curr.second] - 1;
                    q.emplace(make_pair(x, y));
                }
            }
        }
    }

    // We didn't find the second island so return error
    return -1;
}