//Time = O(k logn), n is number of rows. insertion & extraction takes O(log n), and we perform these operations k times. 
//Space = O(n), as we store upto n elements.

import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Edge case: If matrix is empty or k is invalid, return -1
        if (matrix == null || matrix.length == 0 || k <= 0) {
            return -1;
        }

        int n = matrix.length;
        // Min-Heap to store the matrix elements along with their row and column indices
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        
        // Initialize the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Element(matrix[i][0], i, 0));
        }
        
        // Variable to store the current smallest element
        int currentValue = 0;
        
        // Extract the minimum element from the heap k times
        for (int i = 0; i < k; i++) {
            Element minElement = minHeap.poll();
            currentValue = minElement.value;
            int row = minElement.row;
            int col = minElement.col;
            
            // If there's a next column in the same row, add that element to the heap
            if (col + 1 < n) {
                minHeap.offer(new Element(matrix[row][col + 1], row, col + 1));
            }
        }
        
        return currentValue;
    }
    
    // Helper class to store the value and its position in the matrix
    private class Element {
        int value;
        int row;
        int col;
        
        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}
