// Time Complexity : O(N log N) where N is the number of intervals. Sorting the start and end times takes O(N log N) time, and iterating through the sorted arrays takes O(N) time.
// Space Complexity : O(N) for the start and end arrays that we create to store the start and end times of the intervals.
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// 1. We separate the start and end times of the intervals into two separate arrays and sort them.
// 2. We use two pointers to iterate through the sorted start and end arrays. If the start time of the current interval is less than the end time of the earliest ending interval, we
// need a new room, so we increment the room count. Otherwise, we can reuse a room, so we decrement the room count and move the end pointer to the next ending interval.
// 3. We keep track of the maximum number of rooms needed at any point in time, which will be our final answer.

// Your code here along with comments explaining your approach


import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int n = intervals.length;
        int room = 0;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int k = 0; k < n; k++) {
            start[k] = intervals[k][0];
            end[k] = intervals[k][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;
        int res = 0;

        while (i < n) {

            if (start[i] < end[j]) {
                room++;
                res = Math.max(res, room);
                i++;
            } else {
                room--;
                j++;
            }
        }

        return res;
    }
}