import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(findKthSmallest(arr, 0, n - 1, k));
    }
    
    public static int findKthSmallest(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        
        int pivotIndex = partition(arr, left, right);
        
        int rank = pivotIndex - left + 1; 
        
        if (rank == k) {
            return arr[pivotIndex];
        } else if (k < rank) {
            return findKthSmallest(arr, left, pivotIndex - 1, k);
        } else {
            return findKthSmallest(arr, pivotIndex + 1, right, k - rank);
        }
    }
    
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];  
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}