// Time Complexity : O(N*M log k) where N is the number of rows and M is the number of columns in the matrix. We are iterating through all the elements in the matrix and adding them to the priority queue, which takes O(log k) time for each insertion. Since we are maintaining a max heap of size k, we only keep the k smallest elements in the heap at any time.
// Space Complexity : O(k) for the priority queue that holds at most k elements.
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// 1. We use a max heap (priority queue) to keep track of the k smallest elements in the matrix. We iterate through each element in the matrix and add it to the max heap.
 // 2. If the size of the max heap exceeds k, we remove the largest element from the heap, ensuring that we only keep the k smallest elements.
 // 3. After iterating through all elements in the matrix, the top of the max heap will be the kth smallest element, which we return as the result.
 
 // Your code here along with comments explaining your approach
// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        // max heap (reverse order)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int row = matrix.length;
        int col = matrix[0].length;

        pq.offer(matrix[0][0]);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i == 0 && j == 0) continue;

                pq.offer(matrix[i][j]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}