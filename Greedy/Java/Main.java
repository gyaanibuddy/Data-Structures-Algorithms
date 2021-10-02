/*
Problem :- 

Given three integer lists a, b and c, find the minimum possible abs(a[i] - b[j]) + abs(b[j] - c[k]) for any i, j and k.

*/

/*
Intuition
The hint is that j is shared in the equation asked by the problem, while there's no constraints on i and k at all:

   abs(a[i] - b[j]) + abs(b[j] - c[k])
Therefore we can, for each b[j], use binary search to find its closest buddies in a and c, respectively.

Implementation
After sorting the array a and c,
for each element in b, we use a helper function to find it's value-closet element in a and c respectively.
Then we keep and return the minimum of this series of finds.


*/


import java.util.*;

class Solution {
    public int solve(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(c);
        int res = Integer.MAX_VALUE;
        for (int i : b) res = Math.min(helper(i, a) + helper(i, c), res);
        return res;
    }

    private int helper(int val, int[] minor) {
        int min1 = Integer.MAX_VALUE;
        int idx = Arrays.binarySearch(minor, val);
        if (idx >= 0) {
            return 0;
        } else {
            idx = -1 - idx;
            if (idx != minor.length)
                min1 = Math.min(min1, minor[idx] - val);
            if (idx != 0)
                min1 = Math.min(min1, val - minor[idx - 1]);
        }
        return min1;
    }
}