import java.util.Scanner;

public class Main {
    static long count = 0;  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortAndCount(arr, 0, n - 1);
        System.out.println(count);
    }

    static void sortAndCount(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        sortAndCount(arr, left, mid);
        sortAndCount(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;     
        int j = mid + 1;   
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);   
            }
        }

        while (i <= mid)  temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}