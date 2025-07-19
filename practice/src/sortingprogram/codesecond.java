/*Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the
  kth smallest element in the matrix. 
  Note thet it is the kth smallest element in the sorted order, not the kth distinct element.
  You must find a solution with a memory complexity better than O(n2) 
*/

package sortingprogram;

public class codesecond {

    public static int kthSmallest(int [][] matrix, int k){
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while(left < right){
            int mid = left + (right - left) / 2;
            int count = countLessOrEqual(matrix, mid, n);

            if(count < k){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int countLessOrEqual(int[][] matrix, int mid, int n){
        int count = 0;
        int row = n - 1;
        int col = 0;

        while(row >= 0 && col < n){
            if(matrix[row][col] <= mid){
                count += row + 1;
                col ++;
            }else{
                row--;
            }
        }

        return count;

    }

     // Example usage
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 3;

        int result = kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }

}
