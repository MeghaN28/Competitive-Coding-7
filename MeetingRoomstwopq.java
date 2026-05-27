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

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < pq.peek()) {

                // Need a new room
                pq.offer(intervals[i][1]);

            } else {

                // Reuse room
                pq.poll();
                pq.offer(intervals[i][1]);
            }
        }

        return pq.size();
    }
}