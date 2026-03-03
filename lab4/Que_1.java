import java.util.*;

public class Que_1 {

    
    public static void mergeSort(int[] arr, int left, int right) {
       
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      
        int j = mid + 1;   
        int k = 0;         

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {11, 25, 154, 184, 220, 12, 2, 24};

        System.out.println("Before sorting:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After sorting:");
        printArray(arr);
    }
}