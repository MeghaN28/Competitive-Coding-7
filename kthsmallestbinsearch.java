// Time Complexity : O(n log(max - min)) where n is the number of rows/columns in the matrix and max and min are the maximum and minimum values in the matrix respectively. The binary search runs in log(max - min) time, and counting the number of elements less than or equal to mid takes O(n) time.
// Space Complexity : O(1) as we are using only a constant amount of extra space.
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// 1. We perform a binary search on the range of values in the matrix, starting from the smallest element to the largest element.
// 2. For each mid value, we count how many elements in the matrix are less than or equal to mid using a helper function that traverses the matrix from the top-right corner.
// 3. If the count is less than k, we know that the kth smallest element must be greater than mid, so we adjust our search range accordingly. If the count is greater than or equal
// to k, we adjust our search range to look for smaller values. We continue this process until low is equal to high, at which point low (or high) will be the kth smallest element in the matrix.   

// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) { //bin search on value not index. //important to note that low and high are not index but values in the matrix.

            int mid = low + (high - low) / 2;

            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countLessEqual(int[][] matrix, int target) {

        int n = matrix.length; // either first row last col or last row first col as each row and each col is sorted.

        int row = 0;
        int col = n - 1;
        int count = 0;

        while (row < n && col >= 0) {

            if (matrix[row][col] <= target) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }

        return count;
    }
}