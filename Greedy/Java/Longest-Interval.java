/*
Problem :- 
You are given a two-dimensional list of integers intervals where each list represents an inclusive [start, end] interval. 
Return the longest interval that you can make by merging any number of intersecting intervals.

*/

/*
Intuition
Simply sort your interval array by starting times and try to check the continuity by comparing the current starting time with the previous ending time.

Implementation
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
This is the comparator I've used to sort the starting times.

Time Complexity
O(nlogn) As we are just sorting it takes nlogn time and one extra traversal.

Space Complexity
O(1) We are not using any extra space to solve this problem except the given interval array
*/


import java.util.*;

class Solution {
    public int solve(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = 0, end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
                start = Math.min(start, intervals[i][0]);
            } else {
                ans = Math.max(ans, end - start + 1);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans = Math.max(ans, end - start + 1);
        return ans;
    }
}
